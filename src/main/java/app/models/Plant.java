package app.models;

import app.models.Identities.PlantIdentity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name="plant")
public class Plant {

    @EmbeddedId
    private PlantIdentity identity;
    private String image;

    public Plant() {
    }

    public Plant(PlantIdentity identity) {
        this.identity = identity;
    }

    public Plant(PlantIdentity identity, String image) {
        this.identity = identity;
        this.image = image;
    }

}
