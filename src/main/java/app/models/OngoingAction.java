package app.models;

import app.models.Identities.OngoingActionIdentity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@Table(name="ongoingaction")
public class OngoingAction {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private Long possibleActionId;
    private Long plantId;
    private LocalDate creationDate;
    private LocalDate realisationDate;
    private boolean isDone;

    public OngoingAction() {
    }

    public OngoingAction(Long id, Long possibleActionId, Long plantId, LocalDate creationDate, boolean isDone) {
        this.id = id;
        this.possibleActionId = possibleActionId;
        this.plantId = plantId;
        this.creationDate = creationDate;
        this.isDone = isDone;
    }

    public OngoingAction(Long possibleActionId, Long plantId, LocalDate creationDate, boolean isDone) {
        this.possibleActionId = possibleActionId;
        this.plantId = plantId;
        this.creationDate = creationDate;
        this.isDone = isDone;
    }

    public OngoingAction(Long possibleActionId, Long plantId, LocalDate creationDate, LocalDate realisationDate, boolean isDone) {
        this.possibleActionId = possibleActionId;
        this.plantId = plantId;
        this.creationDate = creationDate;
        this.realisationDate = realisationDate;
        this.isDone = isDone;
    }

}
