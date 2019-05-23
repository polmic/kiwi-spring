package app.models.Identities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Embeddable
public class OngoingActionIdentity implements Serializable {

    @NotNull
    private Long possibleActionId;
    @NotNull
    private Long plantId;

    public OngoingActionIdentity() {
    }

    public OngoingActionIdentity(@NotNull Long possibleActionId, @NotNull Long plantId) {
        this.possibleActionId = possibleActionId;
        this.plantId = plantId;
    }

}
