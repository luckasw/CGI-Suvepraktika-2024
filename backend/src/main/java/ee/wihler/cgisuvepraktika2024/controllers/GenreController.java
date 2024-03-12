package ee.wihler.cgisuvepraktika2024.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ee.wihler.cgisuvepraktika2024.entities.Genre;
import ee.wihler.cgisuvepraktika2024.services.GenreServiceImp;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    @Autowired
    private GenreServiceImp genreService;

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable("id")Integer id) {
        Genre genre = genreService.getGenreById(id);
        if (genre == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(genre);
    }

    @PostMapping
    public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre) {
        genreService.saveGenre(genre);
        return ResponseEntity.ok(genre);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable("id")Integer id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }

}
