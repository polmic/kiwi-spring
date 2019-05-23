package app.controllers;

import app.models.Plant;
import app.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlantController {

    private final PlantRepository repository;

    @Autowired
    public PlantController(PlantRepository repository) {
        this.repository = repository;
    }

    // Save
    @PostMapping(path = "/plant", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    Plant newPlant(@RequestBody Plant newPlant) {
        System.out.println(newPlant.toString());
        return repository.save(newPlant);
    }

    // Find
    @GetMapping("/plant/{id}")
    Plant findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("" + id));
    }

    // Save or update
    @PutMapping("/plant/{id}")
    Plant saveOrUpdate(@RequestBody Plant newPlant, @PathVariable Long id) {
        return repository.findById(id)
                .map(x -> {
                    x.setName(newPlant.getName());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newPlant.setId(id);
                    return repository.save(newPlant);
                });
    }

    @DeleteMapping("/plant/{id}")
    void deletePlant(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
