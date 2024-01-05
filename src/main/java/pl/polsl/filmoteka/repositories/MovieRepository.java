package pl.polsl.filmoteka.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

//    @Query("SELECT m.movie_id, m.poster_link, m.title, m.director, m.release_year, m.duration, m.description, " +
//            "g.genre, a.name, a.surname " +
//            "FROM movies m LEFT JOIN movie_genres mg ON m.movie_id = mg.movies_movie_id LEFT JOIN movie_cast mc " +
//            "ON m.movie_id = mc.movies_movie_id LEFT JOIN actors a ON mc.actors_actor_id = a.actor_id LEFT JOIN " +
//            "genres g ON g.genre_id = mg.genres_genre_id GROUP BY m.movie_id")
//    List<Movie> findAllMoviesWithActorsAndGenres();

    @Query("SELECT m FROM Movie m LEFT JOIN FETCH m.actors LEFT JOIN FETCH m.genres")
    List<Movie> findAllDistinctMoviesWithActorsAndGenres();

    List<Movie> findByReleaseYear(Integer releaseYear);

    List<Movie> findByTitle(String title);

    Optional<Movie> findById(Integer id);

    void deleteById(Integer id);
}