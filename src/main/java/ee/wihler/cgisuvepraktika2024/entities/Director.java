package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "directors")
public class Director {
    @Id
    private UUID uuid;

    @Column(name = "directorName")
    private String directorName;

    public Director() {}

    public Director(UUID uuid, String directorName) {
        this.uuid = uuid;
        this.directorName = directorName;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getDirectorName() {
        return directorName;
    }
}
