package app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class OngoingAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //TODO make pk with union of two ids
    private Long possibleActionId;
    private Long plantId;

    private LocalDate creationDate;
    private LocalDate realisationDate;
    private boolean isDone;

    public OngoingAction() {
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
