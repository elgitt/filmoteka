package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Movie;
import pl.polsl.filmoteka.models.User;
import pl.polsl.filmoteka.models.Watchlist;

import java.util.List;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
    @Query("SELECT w.moviesMovie FROM Watchlist w WHERE w.usersUser.id = :userId")
    List<Movie> findMoviesInUserWatchlist(@Param("userId") Integer userId);

    Watchlist findByUsersUserAndMoviesMovie(User user, Movie movie);

    void deleteByUsersUserAndMoviesMovie(User user, Movie movie);

}