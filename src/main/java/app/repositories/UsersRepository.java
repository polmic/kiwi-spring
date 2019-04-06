package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.models.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

}