package app.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {

  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String password;
  private Long homeId;

  public User() {
  }

  public User(Long id, String username, String password, Long homeId) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.homeId = homeId;
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

}
