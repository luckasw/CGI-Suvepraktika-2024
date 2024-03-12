package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "screenings")
public class Screening {
    @Id
    @Column(name = "screening_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movieid", nullable = false)
    private Movie movieid;

    @Column(name = "screening_time", nullable = false)
    private Instant screeningTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovieid() {
        return movieid;
    }

    public void setMovieid(Movie movieid) {
        this.movieid = movieid;
    }

    public Instant getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Instant screeningTime) {
        this.screeningTime = screeningTime;
    }

}