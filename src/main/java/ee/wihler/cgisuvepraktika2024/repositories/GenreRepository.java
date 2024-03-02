package ee.wihler.cgisuvepraktika2024.repositories;

import ee.wihler.cgisuvepraktika2024.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}