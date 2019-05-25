package app.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="possibleaction")
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
