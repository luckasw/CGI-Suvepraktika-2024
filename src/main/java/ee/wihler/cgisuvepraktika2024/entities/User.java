package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    private UUID uuid;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public User() {}

    public User(UUID uuid, String name, String email) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
