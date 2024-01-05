package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Actor;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findByNameAndSurname(String name, String surname);

    List<Actor> findByName(String name);

    List<Actor> findBySurname(String surname);

    Optional<Actor> findById(Integer id);

    void deleteById(Integer id);

    Set<Actor> findBySeriesId(Integer seriesId);


}