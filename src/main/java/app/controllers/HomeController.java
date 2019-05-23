package app.controllers;

import app.models.Home;
import app.repositories.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    private final HomeRepository repository;

    @Autowired
    public HomeController(HomeRepository repository) {
        this.repository = repository;
    }

    // Save
    @PostMapping(path = "/home", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    Home newHome(@RequestBody Home newHome) {
        System.out.println(newHome.toString());
        return repository.save(newHome);
    }

    // Find
    @GetMapping("/home/{id}")
    Home findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("" + id));
    }

    // Save or update
    @PutMapping("/home/{id}")
    Home saveOrUpdate(@RequestBody Home newHome, @PathVariable Long id) {
        return repository.findById(id)
                .map(x -> {
                    x.setHomeName(newHome.getHomeName());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newHome.setId(id);
                    return repository.save(newHome);
                });
    }

    @DeleteMapping("/home/{id}")
    void deleteHome(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
