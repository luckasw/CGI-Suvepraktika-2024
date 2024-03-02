package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "screenings")
public class Screening {
    @Id
    private UUID uuid;

    @Column(name = "movieId")
    private UUID movieId;

    @Column(name = "screeningtime")
    private String screeningTime;

    public Screening() {}

    public Screening(UUID uuid, UUID movieId, String screeningTime) {
        this.uuid = uuid;
        this.movieId = movieId;
        this.screeningTime = screeningTime;
    }

    public UUID getUuid() {
        return uuid;
    }

    public UUID getMovieId() {
        return movieId;
    }

    public String getScreeningTime() {
        return screeningTime;
    }
}
