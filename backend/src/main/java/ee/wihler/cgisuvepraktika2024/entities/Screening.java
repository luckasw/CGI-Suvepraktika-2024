package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "screenings")
public class Screening {
    @Id
    @Column(name = "screeningid", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movieid", nullable = false)
    private Movie movieid;

    @Column(name = "screeningtime", nullable = false)
    private Instant screeningtime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seatingplanid", nullable = false)
    private Seatingplan seatingplanid;

    @Transient
    private double recommendationScore;

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

    public Instant getScreeningtime() {
        return screeningtime;
    }

    public void setScreeningtime(Instant screeningtime) {
        this.screeningtime = screeningtime;
    }

    public double getRecommendationScore() {
        return recommendationScore;
    }

    public void setRecommendationScore(double recommendationScore) {
        this.recommendationScore = recommendationScore;
    }
    public Seatingplan getSeatingplanid() {
        return seatingplanid;
    }

    public void setSeatingplanid(Seatingplan seatingplanid) {
        this.seatingplanid = seatingplanid;
    }

}