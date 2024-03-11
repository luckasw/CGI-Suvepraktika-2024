package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.entities.Genre;
import ee.wihler.cgisuvepraktika2024.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImp implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenreById(Integer id) {
        Optional<Genre> optional = genreRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}
