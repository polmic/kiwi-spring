package app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Home {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String homeName;
    private List<Long> users;

    public Home() {
    }

    public Home(Long id, String homeName, List<Long> users) {
        this.id = id;
        this.homeName = homeName;
        this.users = users;
    }

}
