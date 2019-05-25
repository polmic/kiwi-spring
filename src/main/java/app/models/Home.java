package app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="home")
public class Home {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    private String homeName;

    public Home() {
    }

    public Home(Long id, String homeName) {
        this.id = id;
        this.homeName = homeName;
    }

}
