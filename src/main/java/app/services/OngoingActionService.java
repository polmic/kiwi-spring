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

    public void getOngoingAction(Long id) {
        //return ongoingActionRepository.findOne(id);
    }

    public void addOngoingAction(OngoingAction action) {
        ongoingActionsRepository.save(action);
    }

    public void updateOngoingAction(Long id, OngoingAction action) {
        ongoingActionsRepository.save(action);
    }

    public void deleteOngoingAction(OngoingAction id) {
        ongoingActionsRepository.delete(id);
    }

}
