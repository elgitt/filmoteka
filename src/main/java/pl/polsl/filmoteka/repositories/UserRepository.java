package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

   User findByUsername(String username);


}