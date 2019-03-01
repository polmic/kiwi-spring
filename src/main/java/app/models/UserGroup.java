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
  private List<Long> userIds;

  public UserGroup() {
  }

  public UserGroup(List<Long> userIds) {
    this.userIds = userIds;
  }

  public UserGroup(Long id, List<Long> userIds) {
    this.id = id;
    this.userIds = userIds;
  }

}
