package app.services;

import app.models.Plant;
import app.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    // Retrieve all rows from table and populate list with objects
    public List getAllPlant() {

        List plant = new ArrayList<>();
        plantRepository.findAll().forEach(plant::add);

        return plant;
    }

    // Retrieves one row from table based on given id
    //  public Plant getPlant(Long id) {
    public void getPlant(Long id) {
        //return plantRepository.findOne(id);
    }

    // Inserts row into table
    public void addPlant(Plant plant) {
        plantRepository.save(plant);
    }

    // Updates row in table
    public void updatePlant(Long id, Plant plant) {
        plantRepository.save(plant);
    }

    // Removes row from table
    public void deletePlant(Plant id) {
        plantRepository.delete(id);
    }

}
