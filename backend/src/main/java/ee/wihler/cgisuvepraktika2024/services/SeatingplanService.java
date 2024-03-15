package ee.wihler.cgisuvepraktika2024.services;

public interface SeatingplanService {
    Integer[][] getSeatingPlanById(Integer id);

    Integer[][] getRecommendedSeats(Integer id, Integer people);

    Boolean isOccupied();
}
