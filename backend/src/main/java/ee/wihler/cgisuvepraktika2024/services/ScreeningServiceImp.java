package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.entities.Screening;
import ee.wihler.cgisuvepraktika2024.entities.Usermovie;
import ee.wihler.cgisuvepraktika2024.repositories.ScreeningRepository;
import ee.wihler.cgisuvepraktika2024.repositories.UsermovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;

@Service
public class ScreeningServiceImp implements ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private UsermovieRepository usermovieRepository;

    @Override
    public List<Screening> getAllScreenings() {
        return screeningRepository.findAll();
    }

    @Override
    public Screening getScreeningById(Integer id) {
        Optional<Screening> optional = screeningRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void saveScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    @Override
    public void deleteScreening(Integer id) {
        screeningRepository.deleteById(id);
    }

    @Override
    public List<Screening> getScreeningWithRecommendation(Integer userId) {
        List<Screening> screenings = screeningRepository.findAll();
        List<Usermovie> usermovies = usermovieRepository.findByUseridId(userId);
        List<Screening> screeningsWithRecommendation = new ArrayList<>();
        for (Screening screening : screenings) {
            double recommendationScore = 0;
            for (Usermovie usermovie : usermovies) {
                String UsermovieGenre = usermovie.getMovieid().getGenreid().getGenrename();
                String ScreeningGenre = screening.getMovieid().getGenreid().getGenrename();
                if (UsermovieGenre.equals(ScreeningGenre)) {
                    recommendationScore += 1;
                }
                if (usermovie.getVisitdate() != null) {
                    DayOfWeek usermovieDay = usermovie.getVisitdate().atOffset(ZoneOffset.UTC).getDayOfWeek();
                    DayOfWeek screeningDay = screening.getScreeningtime().atOffset(ZoneOffset.UTC).getDayOfWeek();
                    LocalTime usermovieTime = usermovie.getVisitdate().atOffset(ZoneOffset.UTC).toLocalTime();
                    LocalTime screeningTime = screening.getScreeningtime().atOffset(ZoneOffset.UTC).toLocalTime();
                    if (usermovieDay.equals(screeningDay)) {
                        recommendationScore += 0.5;
                    }
                    if (usermovieTime.isAfter(screeningTime.minusHours(1)) && usermovieTime.isBefore(screeningTime.plusHours(1))) {
                        recommendationScore += 0.5;
                    }
                }
                if (usermovie.getRating() != null) {
                    recommendationScore += usermovie.getRating();
                }
            }
            screening.setRecommendationScore(recommendationScore);
            screeningsWithRecommendation.add(screening);
        }

        screeningsWithRecommendation.sort(Comparator.comparing(Screening::getRecommendationScore).reversed());
        return screeningsWithRecommendation;
    }
}
