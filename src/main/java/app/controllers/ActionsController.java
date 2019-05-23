package app.controllers;

import app.models.OngoingAction;
import app.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActionsController {

    private final ActionService actionService;

    @Autowired
    public ActionsController(ActionService actionService) {
        this.actionService = actionService;
    }

    // Save
    @PostMapping(path = "/action", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    OngoingAction newAction(@PathVariable Long actionId, @PathVariable Long plantId) {
        return actionService.add(actionId, plantId);
    }

    @GetMapping("/action/{actionId}/plant/{plantId}")
    OngoingAction findOngoingAction(@PathVariable Long actionId, @PathVariable Long plantId) {
        return actionService.findOngoingAction(actionId, plantId);
    }

}
