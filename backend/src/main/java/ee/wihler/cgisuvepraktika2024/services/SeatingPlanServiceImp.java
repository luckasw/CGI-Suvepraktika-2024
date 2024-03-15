package ee.wihler.cgisuvepraktika2024.services;

import ee.wihler.cgisuvepraktika2024.repositories.SeatingplanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatingPlanServiceImp implements SeatingplanService {
    @Autowired
    private SeatingplanRepository seatingplanRepository;
    @Override
    public Boolean[][] getSeatingPlanById(Integer id) {
        return new Boolean[20][50];
    }
}
