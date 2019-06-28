package app.repositories;

import app.models.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

    @Query("SELECT p FROM Plant p where p.homeId = :id")
    List<Plant> findByHomeId(@Param("id") Long id);

}