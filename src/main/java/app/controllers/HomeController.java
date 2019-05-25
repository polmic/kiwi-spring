package app.controllers;

import app.models.ApiResponse;
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

    @PostMapping(path = "/home", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<Home> addHome(@RequestBody Home home) {
        ApiResponse<Home> response = new ApiResponse<>();
        response.setResponse(homeService.addHome(home));
        response.setTotal(1);
        return response;
    }

    @GetMapping(path = "/home/{id}", produces = "application/json")
    ApiResponse<Home> getHomeById(@PathVariable Long id) {
        ApiResponse<Home> response = new ApiResponse<>();
        response.setResponse(homeService.getHome(id));
        response.setTotal(1);
        return response;
    }


    @PutMapping(path = "/home/{id}", consumes = "application/json", produces = "application/json")
    ApiResponse<Home> updateHome(@RequestBody Home newHome, @PathVariable Long id) {
        ApiResponse<Home> response = new ApiResponse<>();
        response.setResponse(homeService.updateHome(id, newHome));
        response.setTotal(1);
        return response;
    }

    @DeleteMapping(path = "/home/{id}", produces = "application/json")
    ApiResponse<Boolean> deleteHome(@PathVariable Long id) {
        ApiResponse<Boolean> response = new ApiResponse<>();
        response.setResponse(homeService.deleteHome(id));
        response.setTotal(1);
        return response;

    }

}
