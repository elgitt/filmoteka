package pl.polsl.filmoteka.controllers;

import org.springframework.web.bind.annotation.*;
import pl.polsl.filmoteka.models.Actor;
import pl.polsl.filmoteka.models.Genre;
import pl.polsl.filmoteka.models.Movie;
import pl.polsl.filmoteka.repositories.ActorRepository;
import pl.polsl.filmoteka.repositories.GenreRepository;
import pl.polsl.filmoteka.repositories.MovieRepository;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieRepository movieRepository;


    public MovieController(MovieRepository movieRepository, GenreRepository genreRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;

    }

    @GetMapping("/all")
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

    @GetMapping("/genres/{id}")
    public List<Genre> getGenresByMovieId(@PathVariable Integer id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        return (movie != null) ? movie.getGenres() : null;
    }

    @GetMapping("/actors/{id}")
    public List<Actor> getActorsByMovieId(@PathVariable Integer id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        return (movie != null) ? movie.getActors() : null;
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/update")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieRepository.deleteById(id);
    }


}

