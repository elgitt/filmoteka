package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.models.Tvseries;

public interface TvSeriesRepository extends JpaRepository<Tvseries, Integer> {
}