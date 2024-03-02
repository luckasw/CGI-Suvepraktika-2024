package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "movieid", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "releasedate", nullable = false)
    private LocalDate releasedate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genreid", nullable = false)
    private Genre genreid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "directorid", nullable = false)
    private Director directorid;

    @Column(name = "agerestriction", nullable = false)
    private Integer agerestriction;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "runtime", nullable = false)
    private LocalTime runtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(LocalDate releasedate) {
        this.releasedate = releasedate;
    }

    public Genre getGenreid() {
        return genreid;
    }

    public void setGenreid(Genre genreid) {
        this.genreid = genreid;
    }

    public Director getDirectorid() {
        return directorid;
    }

    public void setDirectorid(Director directorid) {
        this.directorid = directorid;
    }

    public Integer getAgerestriction() {
        return agerestriction;
    }

    public void setAgerestriction(Integer agerestriction) {
        this.agerestriction = agerestriction;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalTime getRuntime() {
        return runtime;
    }

    public void setRuntime(LocalTime runtime) {
        this.runtime = runtime;
    }

}