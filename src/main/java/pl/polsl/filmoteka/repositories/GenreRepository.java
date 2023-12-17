package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.models.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}