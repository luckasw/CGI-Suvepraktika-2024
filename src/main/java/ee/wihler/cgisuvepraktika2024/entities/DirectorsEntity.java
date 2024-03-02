package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "directors", schema = "public", catalog = "cinema")
public class DirectorsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "directorid")
    private int directorid;

    public int getDirectorid() {
        return directorid;
    }

    public void setDirectorid(int directorid) {
        this.directorid = directorid;
    }

    @Basic
    @Column(name = "directorname")
    private String directorname;

    public String getDirectorname() {
        return directorname;
    }

    public void setDirectorname(String directorname) {
        this.directorname = directorname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorsEntity that = (DirectorsEntity) o;
        return directorid == that.directorid && Objects.equals(directorname, that.directorname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directorid, directorname);
    }
}
