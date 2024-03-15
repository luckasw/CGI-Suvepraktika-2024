package ee.wihler.cgisuvepraktika2024.controllers;

import ee.wihler.cgisuvepraktika2024.services.SeatingPlanServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seatingplan")
public class SeatingPlanController {
    @Autowired
    private SeatingPlanServiceImp seatingPlanService;

    @GetMapping("/{id}")
    public Integer[][] getSeatingPlanById(@PathVariable("id")Integer id) {
        return seatingPlanService.getSeatingPlanById(id);
    }
    @GetMapping("/{id}/{people}")
    public Integer[][] getSeatingWithRecommendation(@PathVariable("id")Integer id, @PathVariable("people")Integer people) {
        return seatingPlanService.getRecommendedSeats(id, people);
    }
}
