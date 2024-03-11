package ee.wihler.cgisuvepraktika2024.controllers;

import ee.wihler.cgisuvepraktika2024.services.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ee.wihler.cgisuvepraktika2024.entities.Movie;
import java.util.List;
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieServiceImp movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Integer id) {
        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id")Integer id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
