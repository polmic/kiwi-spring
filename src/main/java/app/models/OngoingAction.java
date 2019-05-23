package app.models;

import app.models.Identities.OngoingActionIdentity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class OngoingAction {

    @EmbeddedId
    private OngoingActionIdentity identity;
    private LocalDate creationDate;
    private LocalDate realisationDate;
    private boolean isDone;

    public OngoingAction() {
    }

    public OngoingAction(OngoingActionIdentity identity, LocalDate creationDate, boolean isDone) {
        this.identity = identity;
        this.creationDate = creationDate;
        this.isDone = isDone;
    }

    public OngoingAction(OngoingActionIdentity identity, LocalDate creationDate, LocalDate realisationDate, boolean isDone) {
        this.identity = identity;
        this.creationDate = creationDate;
        this.realisationDate = realisationDate;
        this.isDone = isDone;
    }

}
