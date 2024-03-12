package ee.wihler.cgisuvepraktika2024.repositories;

import ee.wihler.cgisuvepraktika2024.entities.Usermovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsermovieRepository extends JpaRepository<Usermovie, Integer> {
    List<Usermovie> findByUseridId(Integer userId);
}