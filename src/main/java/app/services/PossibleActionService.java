package app.services;

import app.models.PossibleAction;
import app.repositories.PossibleActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PossibleActionService {

    private final PossibleActionsRepository possibleActionsRepository;

    @Autowired
    public PossibleActionService(PossibleActionsRepository possibleActionsRepository) {
        this.possibleActionsRepository = possibleActionsRepository;
    }

    public List getAllPossibleActions() {
        List actions = new ArrayList<>();
        possibleActionsRepository.findAll().forEach(actions::add);
        return actions;
    }

    public void getPossibleAction(Long id) {
    }

    public void addPossibleAction(PossibleAction possibleAction) {
        possibleActionsRepository.save(possibleAction);
    }

    public void updatePossibleAction(Long id, PossibleAction possibleAction) {
        possibleActionsRepository.save(possibleAction);
    }

    public void deletePossibleAction(PossibleAction id) {
        possibleActionsRepository.delete(id);
    }

}
