package ee.wihler.cgisuvepraktika2024.entities;

import java.io.Serializable;
import java.util.Objects;

public class UsermoviesEntityPK implements Serializable {
    private int userid;
    private int movieid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsermoviesEntityPK that = (UsermoviesEntityPK) o;
        return userid == that.userid && movieid == that.movieid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, movieid);
    }
}
