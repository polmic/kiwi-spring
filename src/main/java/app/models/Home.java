package app.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Home {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String homeName;

    public Home() {
    }

    public Home(Long id, String homeName, String password) {
        this.id = id;
        this.homeName = homeName;
    }

    public Home(String homeName, String password) {
        this.homeName = homeName;
    }

}
