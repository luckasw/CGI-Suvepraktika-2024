package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "usermovies", schema = "public", catalog = "cinema")
@IdClass(ee.wihler.cgisuvepraktika2024.entities.UsermoviesEntityPK.class)
public class UsermoviesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "userid")
    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "movieid")
    private int movieid;

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    @Basic
    @Column(name = "rating")
    private Integer rating;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsermoviesEntity that = (UsermoviesEntity) o;
        return userid == that.userid && movieid == that.movieid && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, movieid, rating);
    }
}
