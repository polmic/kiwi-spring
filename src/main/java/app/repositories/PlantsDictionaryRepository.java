package app.repositories;

import app.models.PlantsDictionary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantsDictionaryRepository extends JpaRepository<PlantsDictionary, Long> {

    @Query("SELECT pl FROM PlantsDictionary pl " +
            "WHERE pl.commonName LIKE CONCAT('%',:search,'%')" +
            "OR pl.family LIKE CONCAT('%',:search,'%')" +
            "OR pl.category LIKE CONCAT('%',:search,'%')" +
            "OR pl.plantUsage LIKE CONCAT('%',:search,'%')" +
            "OR pl.plantType LIKE CONCAT('%',:search,'%')")
    List<PlantsDictionary> getDictionariesFromSearch(@Param("search") String search, Pageable limit);

}