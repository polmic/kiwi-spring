package app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionsService {

    private final OngoingActionService ongoingActionService;
    private final PossibleActionService possibleActionService;

    @Autowired
    public ActionsService(OngoingActionService ongoingActionService, PossibleActionService possibleActionService) {
        this.ongoingActionService = ongoingActionService;
        this.possibleActionService = possibleActionService;
    }

    public List getAllPossibleActions() {
        return possibleActionService.getAllPossibleActions();
    }

    public List getAllOngoingActions() {
        return ongoingActionService.getAllOngoingActions();
    }

}
