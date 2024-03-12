package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ee.wihler.cgisuvepraktika2024.entities.Movie;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService {
    @Autowired
    private MovieRepository movieRepository;


    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Integer id) {
        Optional<Movie> optional = movieRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
}
