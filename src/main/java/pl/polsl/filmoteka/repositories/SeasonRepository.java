package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {
}