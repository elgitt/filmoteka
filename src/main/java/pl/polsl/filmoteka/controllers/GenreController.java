package pl.polsl.filmoteka.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.filmoteka.models.Genre;
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
   public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }
}
