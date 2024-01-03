package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Integer> {

}