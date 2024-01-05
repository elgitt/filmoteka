package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Genre;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findAll();

}