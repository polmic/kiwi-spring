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
        List<OngoingAction> ongoingActions = ongoingActionService.getOngoingAction(actionId, plantId);
        return ongoingActions.get(0);
    }

    public OngoingAction add(Long possibleActionId, Long plantId) {
        LocalDate creationDate = LocalDate.now();
        OngoingAction newAction = new OngoingAction(possibleActionId, plantId, creationDate, false);
        return ongoingActionService.addAction(newAction);
    }
}
