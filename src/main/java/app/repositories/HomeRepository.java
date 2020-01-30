package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.models.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

}