package app.repositories;

import app.models.Identities.OngoingActionIdentity;
import app.models.OngoingAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngoingActionsRepository extends JpaRepository<OngoingAction, OngoingActionIdentity> {

}