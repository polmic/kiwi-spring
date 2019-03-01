package app.models;

import lombok.Data;
import java.util.List;
import javax.persistence.Entity;

@Entity
@Data
public class UserGroup {

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
