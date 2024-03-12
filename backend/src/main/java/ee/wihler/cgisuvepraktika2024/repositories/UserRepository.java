package ee.wihler.cgisuvepraktika2024.repositories;

import ee.wihler.cgisuvepraktika2024.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}