package pl.polsl.filmoteka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.filmoteka.models.Rating;
import pl.polsl.filmoteka.repositories.MovieRepository;
import pl.polsl.filmoteka.repositories.RatingRepository;
import pl.polsl.filmoteka.repositories.SeriesRepository;
import pl.polsl.filmoteka.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/rating")

public class RatingController {

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    private final SeriesRepository seriesRepository;
    private final UserRepository userRepository;

    @Autowired
    public RatingController(RatingRepository ratingRepository, MovieRepository movieRepository, SeriesRepository seriesRepository, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.movieRepository = movieRepository;
        this.seriesRepository = seriesRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Rating> getAllRatings (){
        return ratingRepository.findAll();
    }


    /*// Dodawanie oceny filmu lub serialu
    @PostMapping("/add")
    public ResponseEntity<String> addRating(@RequestParam Integer userId, @RequestParam Integer movieId,
                                            @RequestParam Integer seriesId, @RequestParam Integer ratingValue,
                                            @RequestParam Character isMovie) {
        if (ratingValue < 1 || ratingValue > 10) {
            return ResponseEntity.badRequest().body("Ocena musi być w zakresie 1-10.");
        }

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Rating existingRating;

            if (isMovie == 'Y') {
                Optional<Movie> movieOptional = movieRepository.findById(movieId);
                if (movieOptional.isPresent()) {
                    Movie movie = movieOptional.get();
                    existingRating = ratingRepository.findByUsersUserAndMoviesMovieid(user, movie);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono filmu o podanym ID.");
                }
            } else {
                Optional<Series> seriesOptional = seriesRepository.findById(seriesId);
                if (seriesOptional.isPresent()) {
                    Series series = seriesOptional.get();
                    existingRating = ratingRepository.findByUsersUserAndSeriesSeriesId(user, series);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono serialu o podanym ID.");
                }
            }

            if (existingRating != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Użytkownik już ocenił ten film lub serial.");
            }

            Rating newRating = new Rating();
            newRating.setRating(ratingValue);
            newRating.setIsmovie(isMovie);
            newRating.setUsersUser(user);

            if (isMovie == 'Y') {
                Optional<Movie> movieOptional = movieRepository.findById(movieId);
                if (movieOptional.isPresent()) {
                    Movie movie = movieOptional.get();
                    newRating.setMoviesMovie(movie);
                    ratingRepository.save(newRating);
                    return ResponseEntity.ok("Ocena dla filmu została dodana.");
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono filmu o podanym ID.");
                }
            } else {
                Optional<Series> seriesOptional = seriesRepository.findById(seriesId);
                if (seriesOptional.isPresent()) {
                    Series series = seriesOptional.get();
                    newRating.setSeriesSeries(series);
                    ratingRepository.save(newRating);
                    return ResponseEntity.ok("Ocena dla serialu została dodana.");
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono serialu o podanym ID.");
                }
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono użytkownika o podanym ID.");
        }
    }

    // Przeglądanie ocen użytkownika
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getUserRatings(@PathVariable Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Rating> userRatings = ratingRepository.findByUsersUser(user);
            return ResponseEntity.ok(userRatings);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }*/
}
