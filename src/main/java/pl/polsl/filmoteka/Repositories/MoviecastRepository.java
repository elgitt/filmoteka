package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Moviecast;
import pl.polsl.filmoteka.Models.MoviecastId;

public interface MoviecastRepository extends JpaRepository<Moviecast, MoviecastId> {
}