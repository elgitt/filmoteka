package pl.polsl.filmoteka.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT m FROM Movie m LEFT JOIN FETCH m.actors LEFT JOIN FETCH m.genres")
    List<Movie> findAllDistinctMoviesWithActorsAndGenres();

    List<Movie> findByReleaseYear(Integer releaseYear);

    List<Movie> findByTitle(String title);

    Optional<Movie> findById(Integer id);

    void deleteById(Integer id);
}