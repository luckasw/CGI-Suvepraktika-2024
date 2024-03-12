package ee.wihler.cgisuvepraktika2024.repositories;

import ee.wihler.cgisuvepraktika2024.entities.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
}