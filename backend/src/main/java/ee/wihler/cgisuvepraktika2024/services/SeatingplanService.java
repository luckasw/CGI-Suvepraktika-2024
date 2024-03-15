package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.entities.Seatingplan;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface SeatingplanService {
    Boolean[][] getSeatingPlanById(Integer id);
}
