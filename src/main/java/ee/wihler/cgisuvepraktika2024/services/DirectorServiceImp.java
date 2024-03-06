package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.entities.Director;
import ee.wihler.cgisuvepraktika2024.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImp implements DirectorService{
    @Autowired
    private DirectorRepository directorRepository;
    @Override
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public Director getDirectorById(Integer id) {
        Optional<Director> optional = directorRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void saveDirector(Director director) {
        directorRepository.save(director);
    }

    @Override
    public void deleteDirector(Integer id) {
        directorRepository.deleteById(id);
    }
}
