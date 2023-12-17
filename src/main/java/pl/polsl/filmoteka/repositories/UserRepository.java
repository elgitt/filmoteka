package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

   User findByUsername(String username);

   User findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}