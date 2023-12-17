package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}