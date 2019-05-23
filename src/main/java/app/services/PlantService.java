package app.services;

import app.models.Plant;
import app.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    // Retrieve all rows from table and populate list with objects
    public List getAllPlant() {

        List plant = new ArrayList<>();
        plantRepository.findAll().forEach(plant::add);

        return plant;
    }

    public Plant getPlant(Long id) {
        return plantRepository.findById(id).orElseThrow(() -> new RuntimeException("" + id));
    }

    public Plant addPlant(Plant plant) {
        plantRepository.save(plant);
        // Todo : + de contrôle sur le résultat de l'opération
        return plant;
    }

    public Plant updatePlant(Long id, Plant plant) {
        return plantRepository.findById(id)
                .map(x -> {
                    x.setName(plant.getName());
                    return plantRepository.save(x);
                })
                .orElseGet(() -> {
                    plant.setId(id);
                    return plantRepository.save(plant);
                });
    }

    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
        //TODO : + de contrôle sur le résultat de l'opération
        //TODO : delete ongoingActions for this plant
        //plantRepository.delete(plant);
    }

}
