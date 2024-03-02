package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "screenings", schema = "public", catalog = "cinema")
public class ScreeningsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "screening_id")
    private int screeningId;

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    @Basic
    @Column(name = "movieid")
    private int movieid;

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    @Basic
    @Column(name = "screening_time")
    private Timestamp screeningTime;

    public Timestamp getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Timestamp screeningTime) {
        this.screeningTime = screeningTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScreeningsEntity that = (ScreeningsEntity) o;
        return screeningId == that.screeningId && movieid == that.movieid && Objects.equals(screeningTime, that.screeningTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screeningId, movieid, screeningTime);
    }
}
