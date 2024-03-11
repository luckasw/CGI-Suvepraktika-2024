package ee.wihler.cgisuvepraktika2024.controllers;

import ee.wihler.cgisuvepraktika2024.services.ScreeningServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ee.wihler.cgisuvepraktika2024.entities.Screening;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {
    @Autowired
    private ScreeningServiceImp screeningService;

    @GetMapping
    public List<Screening> getAllScreenings() {
        return screeningService.getAllScreenings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screening> getScreeningById(@PathVariable("id") Integer id) {
        Screening screening = screeningService.getScreeningById(id);
        if (screening == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(screening);
    }

    @PostMapping
    public ResponseEntity<Screening> saveScreening(Screening screening) {
        screeningService.saveScreening(screening);
        return ResponseEntity.ok(screening);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreening(@PathVariable("id")Integer id) {
        screeningService.deleteScreening(id);
        return ResponseEntity.noContent().build();
    }
}
