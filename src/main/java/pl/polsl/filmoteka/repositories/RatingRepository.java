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

}