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

    public List<PlantsDictionary> getPlantsDictionaries(String search) {
        List<PlantsDictionary> plantsDictionaries = new ArrayList<>();
        Pageable limit = PageRequest.of(0, 15);
        plantsDictionaryRepository.getDictionariesFromSearch(search, limit).forEach(plantsDictionaries::add);
        formatCommonName(plantsDictionaries);
        return plantsDictionaries;
    }

    private void formatCommonName(List<PlantsDictionary> plantsDictionaries) {
        for (PlantsDictionary pl : plantsDictionaries) {
            String formatted = pl.getCommonName().split(",")[0];
            pl.setCommonName(formatted);
        }
    }

}
