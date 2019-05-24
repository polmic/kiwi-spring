package app.controllers;

import app.models.ApiResponse;
import app.models.Plant;
import app.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    ApiResponse<Plant> addPlant(@RequestBody Plant plant) {
        ApiResponse<Plant> response = new ApiResponse<>();
        response.setResponse(plantService.addPlant(plant));
        response.setTotal(1);
        return response;
    }

    @GetMapping(path = "/plant/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<Plant> getPlantById(@PathVariable Long id) {
        ApiResponse<Plant> response = new ApiResponse<>();
        response.setResponse(plantService.getPlant(id));
        response.setTotal(1);
        return response;
    }

    @PutMapping(path = "/plant/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<Plant> updatePlant(@RequestBody Plant plant, @PathVariable Long id) {
        ApiResponse<Plant> response = new ApiResponse<>();
        response.setResponse(plantService.updatePlant(id, plant));
        response.setTotal(1);
        return response;
    }

    @DeleteMapping(path = "/plant/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<Boolean> deletePlant(@PathVariable Long id) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        response.setResponse(plantService.deletePlant(id));
        response.setTotal(1);
        return response;
    }

}
