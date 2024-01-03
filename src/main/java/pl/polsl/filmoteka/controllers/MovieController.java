package pl.polsl.filmoteka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.filmoteka.models.Movie;
import pl.polsl.filmoteka.repositories.MovieRepository;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/byYear/{year}")
    public List<Movie> getMoviesByYear(@PathVariable Integer year) {
        return movieRepository.findByReleaseYear(year);

    }
    @GetMapping("/byTitle/{title}")
    public List<Movie> getMoviesByTitle(@PathVariable String title) {
        return movieRepository.findByTitle(title);

    }

}

