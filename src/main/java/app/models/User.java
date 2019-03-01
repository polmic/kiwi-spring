package app.models;

import lombok.Data;

import javax.persistence.*;
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

  public User() {
  }

  public User(Long id, String name, String email, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

}
