package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.repositories.SeatingplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatingPlanServiceImp implements SeatingplanService {
    @Autowired
    private SeatingplanRepository seatingplanRepository;
    @Override
    public Integer[][] getSeatingPlanById(Integer id) {
        return getRandomSeating();
    }

    private Integer[][] getRandomSeating() {
        Integer[][] seatingPlan = new Integer[20][50];
        for (int i = 0; i < seatingPlan[0].length; i++) {
            for (int j = 0; j < seatingPlan.length; j++) {
                if (isOccupied()){
                    seatingPlan[j][i] = 1;
                } else seatingPlan[j][i] = 0;
            }
        }

        return seatingPlan;
    }

    @Override
    public Boolean isOccupied() {
        return Math.random() < 0.33;
    }
}
