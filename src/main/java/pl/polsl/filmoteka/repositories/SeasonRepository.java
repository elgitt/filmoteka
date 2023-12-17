package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.models.Season;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
}