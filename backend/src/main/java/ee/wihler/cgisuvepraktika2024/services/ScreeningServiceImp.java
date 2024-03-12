package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.entities.Screening;
import ee.wihler.cgisuvepraktika2024.repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreeningServiceImp implements ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;
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
}
