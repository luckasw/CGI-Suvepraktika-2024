package ee.wihler.cgisuvepraktika2024.services;

public interface SeatingplanService {
    Integer[][] getSeatingPlanById(Integer id);
    Boolean isOccupied();
}
