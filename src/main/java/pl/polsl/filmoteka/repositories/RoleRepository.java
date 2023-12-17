package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}