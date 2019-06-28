package app.models.Identities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Embeddable
public class PlantIdentity implements Serializable {

    @NotNull
    private Long dicoId;
    @NotNull
    private Long homeId;

    public PlantIdentity() {
    }

    public PlantIdentity(@NotNull Long dicoId, @NotNull Long homeId) {
        this.dicoId = dicoId;
        this.homeId = homeId;
    }

    public Long getHomeId() {
        return this.homeId;
    }

}
