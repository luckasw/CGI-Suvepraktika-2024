package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.entities.User;
import ee.wihler.cgisuvepraktika2024.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUsernameById(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.orElse(null);
    }
}
