package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.models.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}