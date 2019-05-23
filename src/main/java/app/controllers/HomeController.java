package app.controllers;

import app.models.Home;
import app.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    private final HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    // Save
    @PostMapping(path = "/home", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    Home newHome(@RequestBody Home newHome) {
        System.out.println(newHome.toString());
        return homeService.addHome(newHome);
    }

    // Find
    @GetMapping("/home/{id}")
    Home findOne(@PathVariable Long id) {
        return homeService.getHome(id);
    }

    // Save or update
    @PutMapping("/home/{id}")
    Home saveOrUpdate(@RequestBody Home newHome, @PathVariable Long id) {
        return homeService.updateHome(id, newHome);
    }

    @DeleteMapping("/home/{id}")
    void deleteHome(@PathVariable Long id) {
        homeService.deleteHome(id);
    }

}
