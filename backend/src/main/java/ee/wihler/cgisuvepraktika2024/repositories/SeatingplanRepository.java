package ee.wihler.cgisuvepraktika2024.repositories;

import ee.wihler.cgisuvepraktika2024.entities.Seatingplan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatingplanRepository extends JpaRepository<Seatingplan, Integer> {
}