package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usermovies")
public class Usermovie {
    @EmbeddedId
    private UsermovieId id;

    @MapsId("userid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    @MapsId("movieid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movieid", nullable = false)
    private Movie movieid;

    @Column(name = "rating")
    private Integer rating;

    public UsermovieId getId() {
        return id;
    }

    public void setId(UsermovieId id) {
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

}