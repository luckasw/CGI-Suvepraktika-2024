package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    private UUID uuid;

    @Column(name = "title")
    private String title;

    @Column(name = "releaseDate")
    private String releaseDate;

    @Column(name = "genreId")
    private UUID genreId;

    @Column(name = "directorId")
    private UUID directorId;

    @Column(name = "ageRestriction")
    private int ageRestriction;

    @Column(name = "language")
    private String language;

    @Column(name = "runtime")
    private String runtime;

    public Movie() {}

    public Movie(UUID uuid, String title, String releaseDate, UUID genreId, UUID directorId, int ageRestriction, String language, String runtime) {
        this.uuid = uuid;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genreId = genreId;
        this.directorId = directorId;
        this.ageRestriction = ageRestriction;
        this.language = language;
        this.runtime = runtime;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public UUID getGenreId() {
        return genreId;
    }

    public UUID getDirectorId() {
        return directorId;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public String getLanguage() {
        return language;
    }

    public String getRuntime() {
        return runtime;
    }
}
