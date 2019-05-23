package app.repositories;

import app.models.OngoingAction;
import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngoingActionsRepository extends JpaRepository<OngoingAction, Long> {

}