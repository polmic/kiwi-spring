package app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class UserGroup {

  @Id
  @GeneratedValue
  private Long id;

  public UserGroup() {
  }

}
