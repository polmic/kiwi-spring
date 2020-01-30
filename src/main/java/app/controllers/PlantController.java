package app.controllers;

import app.exceptions.BusinessException;
import app.models.ApiResponse;
import app.models.Identities.PlantIdentity;
import app.models.Plant;
import app.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlantController {

    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    // Save
    @PostMapping(path = "/plant", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<Plant> addPlant(@RequestBody Map<String, Long> json) {
        ApiResponse<Plant> response = new ApiResponse<>();
        response.setResponse(plantService.addPlant(json.get("dicoId"), json.get("homeId")));
        response.setTotal(1);
        return response;
    }

    @GetMapping(path = "/plant/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<Plant> getPlantById(@PathVariable Long id) throws BusinessException {
        ApiResponse<Plant> response = new ApiResponse<>();
        response.setResponse(plantService.getPlant(id));
        response.setTotal(1);
        return response;
    }

    @GetMapping(path = "/plant/home/{homeId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<List<Plant>> getPlantsByHomeId(@PathVariable Long homeId) {
        ApiResponse<List<Plant>> response = new ApiResponse<>();
        response.setResponse(plantService.getPlantsByHomeId(homeId));
        response.setTotal(1);
        return response;
    }

    @PutMapping(path = "/plant/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<Plant> updatePlant(@RequestBody Plant plant, @PathVariable Long id) throws BusinessException {
        ApiResponse<Plant> response = new ApiResponse<>();
        response.setResponse(plantService.updatePlant(id, plant));
        response.setTotal(1);
        return response;
    }

    @DeleteMapping(path = "/plant/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<Boolean> deletePlant(@PathVariable Long id) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        response.setResponse(plantService.deletePlant(id));
        response.setTotal(1);
        return response;
    }

}
