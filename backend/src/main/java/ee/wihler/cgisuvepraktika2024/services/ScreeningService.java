package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.entities.Screening;

import java.util.List;
import java.util.Map;

public interface ScreeningService {
    List<Screening> getAllScreenings();
    Screening getScreeningById(Integer id);
    void saveScreening(Screening screening);
    void deleteScreening(Integer id);
    Map<Screening, Double> getScreeningWithRecommendation(Integer userId);
}
