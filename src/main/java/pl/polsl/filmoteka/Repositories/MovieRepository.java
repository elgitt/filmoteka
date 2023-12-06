package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}