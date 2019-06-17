package app.controllers;

import app.exceptions.BusinessException;
import app.models.ApiResponse;
import app.models.PlantsDictionary;
import app.services.PlantsDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantsDictionaryController {

    private final PlantsDictionaryService plantsDictionaryService;

    @Autowired
    public PlantsDictionaryController(PlantsDictionaryService plantsDictionaryService) {
        this.plantsDictionaryService = plantsDictionaryService;
    }

    @GetMapping(path = "/search", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<List<PlantsDictionary>> getPlantsDictionaries(@RequestParam String q) throws BusinessException {
        ApiResponse<List<PlantsDictionary>> response = new ApiResponse<>();
        response.setResponse(plantsDictionaryService.getPlantsDictionaries());
        response.setTotal(1);
        return response;
    }


    /*
    @PostMapping(path = "/plantsdictionary", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ApiResponse<PlantsDictionary> addPlant(@RequestBody PlantsDictionary plantsDictionary) {
        ApiResponse<PlantsDictionary> response = new ApiResponse<>();
        response.setResponse(plantsDictionaryService.addPlantDictionary(plantsDictionary));
        response.setTotal(1);
        return response;
    }
    */

}