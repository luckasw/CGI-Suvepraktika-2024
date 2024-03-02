package ee.wihler.cgisuvepraktika2024.repositories;

import ee.wihler.cgisuvepraktika2024.entities.Usermovie;
import ee.wihler.cgisuvepraktika2024.entities.UsermovieId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsermovieRepository extends JpaRepository<Usermovie, UsermovieId> {
}