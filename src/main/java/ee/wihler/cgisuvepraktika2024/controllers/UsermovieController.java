package ee.wihler.cgisuvepraktika2024.controllers;

import ee.wihler.cgisuvepraktika2024.entities.Usermovie;
import ee.wihler.cgisuvepraktika2024.services.UsermovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usermovies")
public class UsermovieController {
    @Autowired
    private UsermovieServiceImp usermovieService;

    @GetMapping("/{userId}")
    public List<Usermovie> getAllUsermoviesByUserId(@PathVariable("userId") Integer userId) {
        return usermovieService.getAllUsermoviesByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Usermovie> saveUsermovie(@RequestBody Usermovie usermovie) {
        usermovieService.saveUsermovie(usermovie);
        return ResponseEntity.ok(usermovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsermovie(@PathVariable("id") Integer id) {
        usermovieService.deleteUsermovie(id);
        return ResponseEntity.noContent().build();
    }
}
