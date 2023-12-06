package pl.polsl.filmoteka.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.polsl.filmoteka.Models.Movie;
import pl.polsl.filmoteka.Repositories.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(Integer id, Movie updatedMovie) {
        // Logika aktualizacji filmu...
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
}
