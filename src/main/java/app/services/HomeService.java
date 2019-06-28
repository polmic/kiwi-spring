package app.services;

import app.exceptions.BusinessException;
import app.models.Home;
import app.repositories.HomeRepository;
import app.toolkit.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    private final HomeRepository homeRepository;

    @Autowired
    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    // Retrieve all rows from table and populate list with objects
    public List getAllHomes() {
        List homes = new ArrayList<>();
        homeRepository.findAll().forEach(homes::add);
        return homes;
    }

    public Home getHome(Long id) throws BusinessException {
        return homeRepository.findById(id)
                .orElseThrow(() -> new BusinessException(Constants.ErrorMessage.ERROR_GET_HOME, Constants.MessageIds.ERROR_GET_HOME));
    }

    public Home addHome(Home home) {
        homeRepository.save(home);
        // Peut on savoir si l'opération a réussi ? Si oui :
        // Changer l'id de home qui va être return
        // Setter l'id de user.home_id
        return home;
    }

    public Home updateHome(Long id, Home home) throws BusinessException {
        return homeRepository.findById(id)
                .map(x -> {
                    x.setHomeName(home.getHomeName());
                    return homeRepository.save(x);
                }).orElseThrow(() -> new BusinessException(Constants.ErrorMessage.ERROR_UPDATE_HOME, Constants.MessageIds.ERROR_UPDATE_HOME));
    }

    public boolean deleteHome(Long id) {
        homeRepository.deleteById(id);
        return !homeRepository.existsById(id);
    }

}
