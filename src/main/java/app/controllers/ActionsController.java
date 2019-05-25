package app.controllers;

import app.models.ApiResponse;
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

    @PostMapping(path = "/action", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<OngoingAction> addAction(@PathVariable Long actionId, @PathVariable Long plantId) {
        ApiResponse<OngoingAction> response = new ApiResponse<>();
        response.setResponse(actionService.add(actionId, plantId));
        response.setTotal(1);
        return response;
    }

    @GetMapping(path = "/action/{actionId}/plant/{plantId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<OngoingAction> getOngoingAction(@PathVariable Long actionId, @PathVariable Long plantId) {
        ApiResponse<OngoingAction> response = new ApiResponse<>();
        response.setResponse(actionService.findOngoingAction(actionId, plantId));
        response.setTotal(1);
        return response;
    }

}
