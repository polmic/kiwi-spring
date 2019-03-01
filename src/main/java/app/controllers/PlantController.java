package app.controllers;

import app.errors.PlantNotFoundException;
import app.errors.UnsupportedFieldPatchException;
import app.models.Plant;
import app.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlantController {

  private final PlantRepository repository;

  @Autowired
  public PlantController(PlantRepository repository) {
    this.repository = repository;
  }

  // Find
  @GetMapping("/plants")
  List<Plant> findAll() {
    return repository.findAll();
  }

  // Save
  @PostMapping("/plants")
  //return 201 instead of 200
  @ResponseStatus(HttpStatus.CREATED)
  Plant newPlant(@RequestBody Plant newPlant) {
    return repository.save(newPlant);
  }

  // Find
  @GetMapping("/plants/{id}")
  Plant findOne(@PathVariable Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new PlantNotFoundException(id));
  }

  @DeleteMapping("/plant/{id}")
  void deletePlant(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
