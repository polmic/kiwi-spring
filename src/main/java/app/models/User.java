package app.models;

import lombok.Data;
import org.h2.table.Plan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String email;
  private String password;
  private List<Plant> plants;

  public User() {
  }

  public User(Long id, String name, String email, String password, List<Plant> plants) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.plants = plants;
  }

  public User(String name, String email, String password, List<Plant> plants) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.plants = plants;
  }

}
