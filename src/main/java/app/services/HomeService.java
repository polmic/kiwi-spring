package app.services;

import app.models.Home;
import app.repositories.HomeRepository;
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

    public Home getHome(Long id) {
        return homeRepository.findById(id).orElseThrow(() -> new RuntimeException("" + id));
    }

    public Home addHome(Home home) {
        homeRepository.save(home);
        // Todo : + de contrôle sur le résultat de l'opération
        return home;
    }

    public Home updateHome(Long id, Home home) {
        return homeRepository.findById(id)
                .map(x -> {
                    x.setHomeName(home.getHomeName());
                    return homeRepository.save(x);
                })
                .orElseGet(() -> {
                    home.setId(id);
                    return homeRepository.save(home);
                });
    }

    public void deleteHome(Long id) {
        homeRepository.deleteById(id);
        // Todo : + de contrôle sur le résultat de l'opération
        //homeRepository.delete(home);
    }

}
