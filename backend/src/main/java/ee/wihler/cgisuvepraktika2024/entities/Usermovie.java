package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "usermovies")
public class Usermovie {
    @Id
    @Column(name = "usermovieid", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "movieid", nullable = false)
    private Movie movieid;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "visitdate")
    private Instant visitdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Movie getMovieid() {
        return movieid;
    }

    public void setMovieid(Movie movieid) {
        this.movieid = movieid;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Instant getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(Instant visitdate) {
        this.visitdate = visitdate;
    }

}