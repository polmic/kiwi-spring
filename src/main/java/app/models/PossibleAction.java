package app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class PossibleAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long actionId;
    private String name;
    private String description;

    public PossibleAction() {
    }

    public PossibleAction(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
