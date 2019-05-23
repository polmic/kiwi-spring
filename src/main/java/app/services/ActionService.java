package app.services;

import app.models.Identities.OngoingActionIdentity;
import app.models.OngoingAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActionService {

    private final OngoingActionService ongoingActionService;
    private final PossibleActionService possibleActionService;

    @Autowired
    public ActionService(OngoingActionService ongoingActionService, PossibleActionService possibleActionService) {
        this.ongoingActionService = ongoingActionService;
        this.possibleActionService = possibleActionService;
    }

    public List getAllPossibleActions() {
        return possibleActionService.getAllPossibleActions();
    }

    public List getAllOngoingActions() {
        return ongoingActionService.getAllOngoingActions();
    }

    public OngoingAction findOngoingAction(Long actionId, Long plantId) {
        //TODO : query
        return new OngoingAction();
    }

    public OngoingAction add(Long possibleActionId, Long plantId) {
        LocalDate creationDate = LocalDate.now();
        OngoingActionIdentity identity = new OngoingActionIdentity(possibleActionId, plantId);
        OngoingAction newAction = new OngoingAction(identity, creationDate, false);
        return ongoingActionService.addAction(newAction);
        // Todo : + de contrôle sur le résultat de l'opération
    }
}
