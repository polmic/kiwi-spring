package app.services;

import app.repositories.HomeRepository;
import app.models.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;

    // Retrieve all rows from table and populate list with objects
    public List getAllHomes() {

        List homes = new ArrayList<>();
        homeRepository.findAll().forEach(homes::add);

        return homes;
    }

    // Retrieves one row from table based on given id
    //  public Home getHome(Long id) {
    public void getHome(Long id) {
        //return homeRepository.findOne(id);
    }

    // Inserts row into table
    public void addHome(Home home) {
        homeRepository.save(home);
    }

    // Updates row in table
    public void updateHome(Long id, Home home) {
        homeRepository.save(home);
    }

    // Removes row from table
    public void deleteHome(Home id) {
        homeRepository.delete(id);
    }

}
