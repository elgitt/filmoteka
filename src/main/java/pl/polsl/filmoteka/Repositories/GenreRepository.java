package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}