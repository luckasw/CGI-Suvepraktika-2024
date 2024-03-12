package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.entities.Director;

import java.util.List;

public interface DirectorService {
    List<Director> getAllDirectors();
    Director getDirectorById(Integer id);
    void saveDirector(Director director);
    void deleteDirector(Integer id);
}
