package app.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;

  public User() {
  }

  public User(Long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

}
