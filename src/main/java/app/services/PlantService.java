package app.services;

import app.exceptions.BusinessException;
import app.models.Plant;
import app.repositories.PlantRepository;
import app.toolkit.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantService {

    private final PlantRepository plantRepository;

    @Autowired
    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public Plant getPlant(Long id) throws BusinessException {
        return plantRepository.findById(id)
                .orElseThrow(() -> new BusinessException(Constants.ErrorMessage.ERROR_GET_PLANT, Constants.MessageIds.ERROR_GET_PLANT));
    }

    public List<Plant> getPlantsByHomeId(Long id) {
        List<Plant> plants = plantRepository.findByHomeId(id);
        for (Plant p : plants) System.out.println(p.toString());
        return plants;
    }

    public Plant addPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public Plant updatePlant(Long id, Plant plant) throws BusinessException {
        return plantRepository.findById(id)
                .map(x -> {
                    x.setName(plant.getName());
                    return plantRepository.save(x);
                })
                .orElseThrow(() -> new BusinessException(Constants.ErrorMessage.ERROR_UPDATE_PLANT, Constants.MessageIds.ERROR_UPDATE_PLANT));
    }

    public boolean deletePlant(Long id) {
        plantRepository.deleteById(id);
        return plantRepository.existsById(id);
    }

}
