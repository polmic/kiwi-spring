package app.controllers;

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
    Plant newPlant(@RequestBody Plant newPlant) {
        System.out.println(newPlant.toString());
        return plantService.addPlant(newPlant);
    }

    @GetMapping("/plant/{id}")
    Plant findOne(@PathVariable Long id) {
        return plantService.getPlant(id);
    }

    @PutMapping("/plant/{id}")
    Plant saveOrUpdate(@RequestBody Plant newPlant, @PathVariable Long id) {
        return plantService.updatePlant(id, newPlant);
    }

    @DeleteMapping("/plant/{id}")
    void deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
    }

}
