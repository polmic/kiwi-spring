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

    public List getAllPlant() {
        List plant = new ArrayList<>();
        plantRepository.findAll().forEach(plant::add);
        return plant;
    }

    public Plant getPlant(Long id) {
        return plantRepository.findById(id).orElseThrow(() -> new RuntimeException("" + id));
    }

    public Plant addPlant(Plant plant) {
        return plantRepository.save(plant);
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

    public boolean deletePlant(Long id) {
        plantRepository.deleteById(id);
        return plantRepository.existsById(id);
    }

}
