package ee.wihler.cgisuvepraktika2024.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "seatingplan")
public class Seatingplan {
    @Id
    @Column(name = "seatingplanid", nullable = false)
    private Integer id;

    @Column(name = "seatingplan", nullable = false)
    private List<Boolean> seatingplan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Boolean> getSeatingplan() {
        return seatingplan;
    }

    public void setSeatingplan(List<Boolean> seatingplan) {
        this.seatingplan = seatingplan;
    }

}