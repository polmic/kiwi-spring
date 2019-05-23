package app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class OngoingAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //TODO make pk with union of two ids
    private Long actionId;
    private Long plantId;

    private Date creationDate;
    private Date realisationDate;
    private boolean isDone;

    public OngoingAction() {
    }

    public OngoingAction(Long plantId, Date creationDate, Date realisationDate, boolean isDone) {
        this.plantId = plantId;
        this.creationDate = creationDate;
        this.realisationDate = realisationDate;
        this.isDone = isDone;
    }

}
