package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Movie;
import pl.polsl.filmoteka.models.Series;
import pl.polsl.filmoteka.models.User;
import pl.polsl.filmoteka.models.Watchlist;

import java.util.List;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
    List<Watchlist> findByUsersUser(User user);

    Watchlist findByUsersUserAndMoviesMovie(User user, Movie movie);

    Watchlist findByUsersUserAndSeriesSeries(User user, Series series);

    @Query(value = "SELECT U.NAME, u.user_id, u.surname, WL.watchlist_id, m.movie_id, s.series_id, " +
            "ifnull(m.title, S.title) title, CASE WHEN m.title IS NOT NULL THEN 'Movie' WHEN S.title IS NOT NULL THEN " +
            "'Series' END TYPE, COUNT(DISTINCT se.season_id) AS 'number of seasons' FROM USERS U LEFT JOIN watchlists WL " +
            "ON U.USER_ID = WL.users_user_id LEFT JOIN movies m ON Wl.movies_movie_id = m.movie_id AND wl.movie_series_type = 'M' " +
            "LEFT JOIN series s ON Wl.series_series_id = s.series_id AND wl.movie_series_type = 'S'LEFT JOIN seasons se ON " +
            "S.series_id = se.series_series_id LEFT JOIN episodes e ON se.season_id = e.seasons_season_id WHERE u.user_id= :userid " +
            "GROUP BY U.NAME, u.user_id, u.surname, WL.watchlist_id, m.movie_id, s.series_id, ifnull(m.title, S.title), CASE WHEN m.title " +
            "IS NOT NULL THEN 'Movie' WHEN S.title IS NOT NULL THEN 'Series' END ", nativeQuery = true)
    List<Object[]> findUsersWatchlist(@Param("userid") int userid);
}