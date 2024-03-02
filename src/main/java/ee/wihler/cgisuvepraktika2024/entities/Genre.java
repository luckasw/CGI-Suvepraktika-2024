package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    private UUID uuid;

    @Column(name = "genreName")
    private String genreName;

    public Genre() {}

    public Genre(UUID uuid, String genreName) {
        this.uuid = uuid;
        this.genreName = genreName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getGenreName() {
        return genreName;
    }
}
