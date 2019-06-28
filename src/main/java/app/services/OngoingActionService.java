package app.services;

import app.models.OngoingAction;
import app.repositories.OngoingActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OngoingActionService {

    private final OngoingActionsRepository ongoingActionsRepository;

    @Autowired
    public OngoingActionService(OngoingActionsRepository ongoingActionsRepository) {
        this.ongoingActionsRepository = ongoingActionsRepository;
    }

    public List getAllOngoingActions() {
        List actions = new ArrayList<>();
        ongoingActionsRepository.findAll().forEach(actions::add);
        return actions;
    }

    public OngoingAction addAction(OngoingAction action) {
        ongoingActionsRepository.save(action);
        // Todo : + de contrôle sur le résultat de l'opération
        return action;
    }

    public List<OngoingAction> getOngoingAction(Long actionId, Long plantId) {
        return ongoingActionsRepository.findOngoingAction(actionId, plantId);
    }

    public void updateAction(Long id, OngoingAction action) {
        ongoingActionsRepository.save(action);
    }

    public void deleteAction(OngoingAction id) {
        ongoingActionsRepository.delete(id);
    }

}
