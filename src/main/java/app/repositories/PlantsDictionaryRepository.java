package app.repositories;

import app.models.PlantsDictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantsDictionaryRepository extends JpaRepository<PlantsDictionary, Long> {

}