package app.repositories;

import app.models.Identities.OngoingActionIdentity;
import app.models.OngoingAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OngoingActionsRepository extends JpaRepository<OngoingAction, OngoingActionIdentity> {

    @Query("SELECT oa FROM OngoingAction oa WHERE oa.possibleActionId = :actionId AND oa.plantId = :plantId")
    List<OngoingAction> findOngoingAction(Long actionId, Long plantId);

}