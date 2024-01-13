package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Movie;
import pl.polsl.filmoteka.models.Rating;
import pl.polsl.filmoteka.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByUsersUser(User user);

    @Query("SELECT r, r.moviesMovie FROM Rating r WHERE r.usersUser.id = :userId")
    List<Object[]> findRatingsWithMoviesByUserId(@Param("userId") Integer userId);

    Optional<Rating> findByUsersUserAndMoviesMovie(User user, Movie movie);

    @Query("SELECT g2.genre, AVG(r.rating) as avgRating " +
            "FROM Rating r " +
            "LEFT JOIN MoviesGenre mg ON mg.moviesMovie.id = r.moviesMovie.id " +
            "LEFT JOIN Genre g2 ON g2.id = mg.genresGenre.id " +
            "WHERE r.usersUser.id = :userId " +
            "GROUP BY g2.genre " +
            "HAVING AVG(r.rating) >= 7.5 " +
            "ORDER BY AVG(r.rating) DESC " +
             "LIMIT 3")
    List<Object[]> getTopGenresForUser(@Param("userId") Integer userId);

    @Query("SELECT m.posterLink, m.id, m.description, m.director, m.duration, m.type, m.seasons, m.releaseYear, m.title, g2.genre " +
            "FROM Movie m " +
            "JOIN MoviesGenre mg ON m.id = mg.moviesMovie.id " +
            "JOIN Genre g2 ON g2.id = mg.genresGenre.id " +
            "WHERE g2.genre IN (" +
            "    SELECT g3.genre " +
            "    FROM Rating r " +
            "    LEFT JOIN MoviesGenre mg2 ON mg2.moviesMovie.id = r.moviesMovie.id " +
            "    LEFT JOIN Genre g3 ON g3.id = mg2.genresGenre.id " +
            "    WHERE r.usersUser.id = :userId " +
            "    GROUP BY g3.genre " +
            "    HAVING AVG(r.rating) >= 7.5" +
            ")")
    List<Object[]> getMoviesForTopGenres(@Param("userId") Integer userId);

}


