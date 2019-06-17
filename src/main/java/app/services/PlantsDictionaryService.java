package app.services;

import app.models.PlantsDictionary;
import app.repositories.PlantsDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantsDictionaryService {

    private final PlantsDictionaryRepository plantsDictionaryRepository;

    @Autowired
    public PlantsDictionaryService(PlantsDictionaryRepository plantsDictionaryRepository) {
        this.plantsDictionaryRepository = plantsDictionaryRepository;
    }

    public PlantsDictionary addPlantDictionary(PlantsDictionary plantsDictionary) {
        return plantsDictionaryRepository.save(plantsDictionary);
    }

    public List<PlantsDictionary> getPlantsDictionaries() {
        List<PlantsDictionary> plantsDictionaries = new ArrayList<>();
        Pageable limit = PageRequest.of(0,10);
        plantsDictionaryRepository.findAll(limit).forEach(plantsDictionaries::add);
        return plantsDictionaries;
    }


}
