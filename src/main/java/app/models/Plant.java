package app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Long homeId;

    public Plant() {
    }

    public Plant(Long id, String name, String image, Long homeId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.homeId = homeId;
    }

    public Plant(String name, String image, Long homeId) {
        this.name = name;
        this.image = image;
        this.homeId = homeId;
    }

}