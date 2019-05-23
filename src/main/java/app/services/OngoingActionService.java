package app.services;

import app.models.OngoingAction;
import app.repositories.OngoingActionsRepository;
import app.repositories.PossibleActionsRepository;
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

    public void getOngoingAction(Long id) {
        //return ongoingActionRepository.findOne(id);
    }

    public void addOngoingAction(OngoingAction ongoingAction) {
        ongoingActionsRepository.save(ongoingAction);
    }

    public void updateOngoingAction(Long id, OngoingAction ongoingAction) {
        ongoingActionsRepository.save(ongoingAction);
    }

    public void deleteOngoingAction(OngoingAction id) {
        ongoingActionsRepository.delete(id);
    }

}
