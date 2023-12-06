package pl.polsl.filmoteka.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.polsl.filmoteka.Models.Genre;
import pl.polsl.filmoteka.Services.GenreService;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Integer id) {
        return genreService.getGenreById(id);
    }

    @PostMapping
    public void addGenre(@RequestBody Genre genre) {
        genreService.addGenre(genre);
    }

    @PutMapping("/{id}")
    public void updateGenre(@PathVariable Integer id, @RequestBody Genre updatedGenre) {
        genreService.updateGenre(id, updatedGenre);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Integer id) {
        genreService.deleteGenre(id);
    }
}
