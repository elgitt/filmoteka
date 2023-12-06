package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Season;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
}