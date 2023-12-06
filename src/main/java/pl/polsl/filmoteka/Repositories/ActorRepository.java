package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}