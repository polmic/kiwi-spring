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
  private String username;
  private String email;
  private String password;

  public User() {
  }

  public User(Long id, String username, String email, String password) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public User(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

}
