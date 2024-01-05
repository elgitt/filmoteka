package pl.polsl.filmoteka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.filmoteka.models.*;
import pl.polsl.filmoteka.repositories.MovieRepository;
import pl.polsl.filmoteka.repositories.SeriesRepository;
import pl.polsl.filmoteka.repositories.UserRepository;
import pl.polsl.filmoteka.repositories.WatchlistRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/watchlist")

public class WatchlistController {

    private final WatchlistRepository watchlistRepository;
    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;
    private final UserRepository userRepository;

    @Autowired
    public WatchlistController(WatchlistRepository watchlistRepository, MovieRepository movieRepository, SeriesRepository seriesRepository, UserRepository userRepository) {
        this.watchlistRepository = watchlistRepository;
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Watchlist> getAllWatchlists(){
        return watchlistRepository.findAll();
    }

    @GetMapping("/getByUser")
    public List<Object[]> getUserWatchlists(@RequestParam Integer userid){
        return watchlistRepository.findUsersWatchlist(userid);
    }


    // Dodawanie filmu lub serialu do watchlisty użytkownika
    @PostMapping("/add")
    public ResponseEntity<String> addToWatchlist(@RequestParam Integer userId, @RequestParam Integer movieId,
                                                 @RequestParam Integer seriesId, @RequestParam Character isMovie) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Watchlist existingWatchlistItem;

            if (isMovie == 'Y') {
                Optional<Movie> movieOptional = movieRepository.findById(movieId);
                if (movieOptional.isPresent()) {
                    Movie movie = movieOptional.get();
                    existingWatchlistItem = watchlistRepository.findByUsersUserAndMoviesMovie(user, movie);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono filmu o podanym ID.");
                }
            } else {
                Optional<Series> seriesOptional = seriesRepository.findById(seriesId);
                if (seriesOptional.isPresent()) {
                    Series series = seriesOptional.get();
                    existingWatchlistItem = watchlistRepository.findByUsersUserAndSeriesSeries(user, series);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono serialu o podanym ID.");
                }
            }

            if (existingWatchlistItem != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Element już znajduje się na liście watchlisty użytkownika.");
            }

            Watchlist newWatchlistItem = new Watchlist();

            newWatchlistItem.setUsersUser(user);

            if (isMovie == 'Y') {
                Optional<Movie> movieOptional = movieRepository.findById(movieId);
                if (movieOptional.isPresent()) {
                    Movie movie = movieOptional.get();
                    newWatchlistItem.setMoviesMovie(movie);
                    watchlistRepository.save(newWatchlistItem);
                    return ResponseEntity.ok("Film został dodany do watchlisty.");
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono filmu o podanym ID.");
                }
            } else {
                Optional<Series> seriesOptional = seriesRepository.findById(seriesId);
                if (seriesOptional.isPresent()) {
                    Series series = seriesOptional.get();
                    newWatchlistItem.setSeriesSeries(series);
                    watchlistRepository.save(newWatchlistItem);
                    return ResponseEntity.ok("Serial został dodany do watchlisty.");
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono serialu o podanym ID.");
                }
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono użytkownika o podanym ID.");
        }
    }
    // Przeglądanie watchlisty użytkownika
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Watchlist>> getUserWatchlist(@PathVariable Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Watchlist> userWatchlist = watchlistRepository.findByUsersUser(user);
            return ResponseEntity.ok(userWatchlist);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Usuwanie filmu lub serialu z watchlisty użytkownika
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFromWatchlist(@RequestParam Integer userId, @RequestParam Integer watchlistItemId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<Watchlist> watchlistItemOptional = watchlistRepository.findById(watchlistItemId);

            if (watchlistItemOptional.isPresent()) {
                Watchlist watchlistItem = watchlistItemOptional.get();

                if (!watchlistItem.getUsersUser().equals(user)) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Podany element nie należy do użytkownika.");
                }

                watchlistRepository.delete(watchlistItem);
                return ResponseEntity.ok("Element został usunięty z watchlisty.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono elementu watchlisty o podanym ID.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono użytkownika o podanym ID.");
        }
    }
}
