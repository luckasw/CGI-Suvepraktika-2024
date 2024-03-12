package ee.wihler.cgisuvepraktika2024.repositories;

import ee.wihler.cgisuvepraktika2024.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}