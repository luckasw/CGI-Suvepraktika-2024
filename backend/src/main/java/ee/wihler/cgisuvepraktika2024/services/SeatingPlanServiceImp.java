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
        Integer[][] seatingPlan = getRandomSeating();
        return seatingPlan;
    }

    @Override
    public Integer[][] getRecommendedSeats(Integer id, Integer people) {
        Integer[][] seatingPlan = getRandomSeating();
        double centerX = seatingPlan[0].length / 2.0;
        double centerY = seatingPlan.length / 2.0;
        Integer[] bestSeats = new Integer[people];
        Integer bestRow = null;
        double nearestDistance = Double.MAX_VALUE;

        for (int i = 0; i < seatingPlan.length; i++) {
            for (int j = 0; j < seatingPlan[0].length; j++) {
                Boolean free = true;
                Integer[] foundSeats = new Integer[people];
                int index = 0;
                if (j + people >= seatingPlan[0].length) {
                    free = false;
                    break;
                }
                for (int k = j; k < j + people; k++) {
                    if (seatingPlan[i][j] != 0) {
                        free = false;
                        break;
                    }
                    foundSeats[index] = k;
                    index++;
                }
                if (free) {
                    double foundCenterX = (foundSeats[0] + foundSeats[people - 1]) / 2.0;
                    double foundCenterY = i;
                    double distance = Math.abs(foundCenterX - centerX) + Math.abs(foundCenterY - centerY);
                    if (distance < nearestDistance) {
                        nearestDistance = distance;
                        bestSeats = new Integer[people];
                        bestRow = i;
                        for (int k = 0; k < foundSeats.length; k++) {
                            bestSeats[k] = foundSeats[k];
                        }
                    }
                }
            }
        }

        if (bestRow == null) return seatingPlan;
        for (int i = bestSeats[0]; i < bestSeats[people-1] + 1; i++) {
            seatingPlan[bestRow][i] = 2;
        }

        return seatingPlan;
    }
    private Integer[][] getRandomSeating() {
        Integer[][] seatingPlan = new Integer[20][30];
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
