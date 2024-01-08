package pl.polsl.filmoteka.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.filmoteka.models.Movie;
import pl.polsl.filmoteka.models.User;
import pl.polsl.filmoteka.models.Watchlist;
import pl.polsl.filmoteka.repositories.MovieRepository;
import pl.polsl.filmoteka.repositories.UserRepository;
import pl.polsl.filmoteka.repositories.WatchlistRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/watchlist")

public class WatchlistController {

    private final WatchlistRepository watchlistRepository;
    private final MovieRepository movieRepository;
   // private final SeriesRepository seriesRepository;
    private final UserRepository userRepository;

    @Autowired
    public WatchlistController(WatchlistRepository watchlistRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.watchlistRepository = watchlistRepository;
        this.movieRepository = movieRepository;
        //this.seriesRepository = seriesRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Watchlist> getAllWatchlists(){
        return watchlistRepository.findAll();
    }

    @GetMapping("/getByUser")
    public ResponseEntity<List<Movie>> getUserWatchlists(@RequestParam Integer userId) {
        List<Movie> userWatchlist = watchlistRepository.findMoviesInUserWatchlist(userId);

        if (!userWatchlist.isEmpty()) {
            return ResponseEntity.ok(userWatchlist);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToWatchlist(@RequestParam Integer userId, @RequestParam Integer movieId) {
        User user = userRepository.findById(userId).orElse(null);
        Movie movie = movieRepository.findById(movieId).orElse(null);

        if (user == null || movie == null) {
            return ResponseEntity.badRequest().body("User or movie not found");
        }

        Watchlist existingWatchlistEntry = watchlistRepository.findByUsersUserAndMoviesMovie(user, movie);

        if (existingWatchlistEntry != null) {
            return ResponseEntity.badRequest().body("Movie already in the watchlist");
        }

        Watchlist watchlistEntry = new Watchlist();
        watchlistEntry.setUsersUser(user);
        watchlistEntry.setMoviesMovie(movie);

        watchlistRepository.save(watchlistEntry);

        return ResponseEntity.ok("Movie added to watchlist successfully");
    }

    @Transactional
    @DeleteMapping("/delete")
    public ResponseEntity<String> removeFromWatchlist(@RequestParam Integer userId, @RequestParam Integer movieId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Movie> movieOptional = movieRepository.findById(movieId);

        if (userOptional.isPresent() && movieOptional.isPresent()) {
            User user = userOptional.get();
            Movie movie = movieOptional.get();

            watchlistRepository.deleteByUsersUserAndMoviesMovie(user, movie);

            return ResponseEntity.ok("Movie removed from watchlist successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or movie not found");
        }
    }

}
