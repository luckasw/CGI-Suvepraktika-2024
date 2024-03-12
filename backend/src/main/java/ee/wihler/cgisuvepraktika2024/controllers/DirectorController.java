package ee.wihler.cgisuvepraktika2024.controllers;

import ee.wihler.cgisuvepraktika2024.entities.Director;
import ee.wihler.cgisuvepraktika2024.services.DirectorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {
    @Autowired
    private DirectorServiceImp directorService;

    @GetMapping
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable("id")Integer id) {
        Director director = directorService.getDirectorById(id);
        if (director == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(director);
    }

    @PostMapping
    public ResponseEntity<Director> saveDirector(@RequestBody Director director) {
        directorService.saveDirector(director);
        return ResponseEntity.ok(director);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable("id")Integer id) {
        directorService.deleteDirector(id);
        return ResponseEntity.noContent().build();
    }
}
