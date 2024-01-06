package pl.polsl.filmoteka.controllers;

import org.springframework.web.bind.annotation.*;
import pl.polsl.filmoteka.models.Genre;
import pl.polsl.filmoteka.models.Movie;
import pl.polsl.filmoteka.models.Series;
import pl.polsl.filmoteka.repositories.GenreRepository;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Integer id) {
        return genreRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Genre addGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    @PutMapping("/update")
    public Genre updateGenre(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGenre(@PathVariable Integer id) {
        genreRepository.deleteById(id);
    }

    @GetMapping("/{id}/movies")
    public List<Movie> getMoviesByGenreId(@PathVariable Integer id) {
        Genre genre = genreRepository.findById(id).orElse(null);
        return (genre != null) ? genre.getMovies() : null;
    }

    @GetMapping("/{id}/series")
    public List<Series> getSeriesByGenreId(@PathVariable Integer id) {
        Genre genre = genreRepository.findById(id).orElse(null);
        return (genre != null) ? genre.getSeries() : null;
    }
}
