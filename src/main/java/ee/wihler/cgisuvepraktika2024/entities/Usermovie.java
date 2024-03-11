package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usermovies")
public class Usermovie {
    @Id
    @Column(name = "usermovieid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usermovieuserid")
    private User usermovieuserid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usermoviemovieid")
    private Movie usermoviemovieid;

    @Column(name = "rating")
    private Integer rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUsermovieuserid() {
        return usermovieuserid;
    }

    public void setUsermovieuserid(User usermovieuserid) {
        this.usermovieuserid = usermovieuserid;
    }

    public Movie getUsermoviemovieid() {
        return usermoviemovieid;
    }

    public void setUsermoviemovieid(Movie usermoviemovieid) {
        this.usermoviemovieid = usermoviemovieid;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}