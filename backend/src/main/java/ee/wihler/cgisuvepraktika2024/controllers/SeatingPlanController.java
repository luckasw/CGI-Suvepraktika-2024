package ee.wihler.cgisuvepraktika2024.controllers;

import ee.wihler.cgisuvepraktika2024.services.SeatingPlanServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seatingplan")
public class SeatingPlanController {
    @Autowired
    private SeatingPlanServiceImp seatingPlanService;

    @GetMapping("/{id}")
    public Integer[][] getSeatingPlanById(@PathVariable("id")Integer id) {
        return seatingPlanService.getSeatingPlanById(id);
    }
}
