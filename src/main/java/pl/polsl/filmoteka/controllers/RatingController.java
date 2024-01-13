package pl.polsl.filmoteka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.filmoteka.models.Movie;
import pl.polsl.filmoteka.models.Rating;
import pl.polsl.filmoteka.models.User;
import pl.polsl.filmoteka.repositories.MovieRepository;
import pl.polsl.filmoteka.repositories.RatingRepository;
import pl.polsl.filmoteka.repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    @Autowired
    public RatingController(RatingRepository ratingRepository, MovieRepository movieRepository, UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<Rating> getAllRatings (){
        return ratingRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOrUpdateRating(
            @RequestParam Integer userId,
            @RequestParam Integer movieId,
            @RequestParam Integer rating
    ) {
        try {
            Optional<User> userOptional = userRepository.findById(userId);
            Optional<Movie> movieOptional = movieRepository.findById(movieId);

            if (userOptional.isPresent() && movieOptional.isPresent()) {
                User user = userOptional.get();
                Movie movie = movieOptional.get();

                Optional<Rating> existingRatingOptional = ratingRepository.findByUsersUserAndMoviesMovie(user, movie);

                if (existingRatingOptional.isPresent()) {
                    Rating existingRating = existingRatingOptional.get();
                    existingRating.setRating(rating);
                    existingRating.setRatingDate(LocalDate.now());
                    ratingRepository.save(existingRating);
                    return ResponseEntity.ok("Ocena zaktualizowana pomyślnie.");
                } else {
                    Rating newRating = new Rating();
                    newRating.setUsersUser(user);
                    newRating.setMoviesMovie(movie);
                    newRating.setRating(rating);
                    newRating.setRatingDate(LocalDate.now());

                    ratingRepository.save(newRating);
                    return ResponseEntity.ok("Ocena dodana pomyślnie.");
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Nie znaleziono użytkownika lub filmu o podanym identyfikatorze.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Wystąpił błąd podczas dodawania/aktualizacji oceny.");
        }
    }

    @GetMapping("/getByUser")
    public ResponseEntity<List<Object[]>> getUserRatingsWithMovies(@RequestParam Integer userId) {
        try {
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                List<Object[]> userRatingsWithMovies = ratingRepository.findRatingsWithMoviesByUserId(userId);
                return ResponseEntity.ok(userRatingsWithMovies);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateRating(@RequestParam Integer ratingId, @RequestParam Integer updatedRating) {
        try {
            Optional<Rating> existingRatingOptional = ratingRepository.findById(ratingId);

            if (existingRatingOptional.isPresent()) {
                Rating existingRating = existingRatingOptional.get();

                existingRating.setRating(updatedRating);

                existingRating.setRatingDate(LocalDate.now());

                ratingRepository.save(existingRating);
                return ResponseEntity.ok("Ocena zaktualizowana pomyślnie.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono oceny o podanym identyfikatorze.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Wystąpił błąd podczas aktualizacji oceny.");
        }
    }

    @GetMapping("/topGenresForUser")
    public List<Object[]> getTopGenresForUser(@RequestParam Integer userId) {
        return ratingRepository.getTopGenresForUser(userId);
    }

    @GetMapping("/moviesForTopGenres")
    public List<Object[]> getMoviesForTopGenres(@RequestParam Integer userId) {
        return ratingRepository.getMoviesForTopGenres(userId);
    }

}