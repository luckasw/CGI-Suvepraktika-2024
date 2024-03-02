package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "usermovies")
public class UserMovie {
    @Id
    private UUID uuid;

    @Column(name = "userId")
    private UUID userId;

    @Column(name = "movieId")
    private UUID movieId;

    @Column(name = "rating")
    private int rating;

    public UserMovie() {}

    public UserMovie(UUID uuid, UUID userId, UUID movieId, int rating) {
        this.uuid = uuid;
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
    }

    public UUID getUuid() {
        return uuid;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getMovieId() {
        return movieId;
    }

    public int getRating() {
        return rating;
    }
}
