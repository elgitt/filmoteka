package pl.polsl.filmoteka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.filmoteka.models.Genre;
import pl.polsl.filmoteka.repositories.GenreRepository;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(Integer id) {
        return genreRepository.findById(id).orElse(null);
    }

    public void addGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void updateGenre(Integer id, Genre updatedGenre) {
        // Logika aktualizacji gatunku...
    }

    public void deleteGenre(Integer id) {
        genreRepository.deleteById(id);
    }
}
