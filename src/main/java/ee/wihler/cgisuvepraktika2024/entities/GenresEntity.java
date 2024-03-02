package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "genres", schema = "public", catalog = "cinema")
public class GenresEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "genreid")
    private int genreid;

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    @Basic
    @Column(name = "genrename")
    private String genrename;

    public String getGenrename() {
        return genrename;
    }

    public void setGenrename(String genrename) {
        this.genrename = genrename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenresEntity that = (GenresEntity) o;
        return genreid == that.genreid && Objects.equals(genrename, that.genrename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreid, genrename);
    }
}
