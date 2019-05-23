package app.repositories;

import app.models.PossibleAction;
import app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PossibleActionsRepository extends JpaRepository<PossibleAction, Long> {

}