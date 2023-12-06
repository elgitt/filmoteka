package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Tvseries;

public interface TvseriesRepository extends JpaRepository<Tvseries, Integer> {
}