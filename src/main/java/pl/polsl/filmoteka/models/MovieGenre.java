package pl.polsl.filmoteka.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_genres")
public class MovieGenre {
    @EmbeddedId
    private MovieGenreId id;

    @MapsId("moviesMovieId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movies_movie_id", nullable = false)
    private Movie moviesMovie;

    @MapsId("genresGenreId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genres_genre_id", nullable = false)
    private Genre genresGenre;

    public MovieGenreId getId() {
        return id;
    }

    public void setId(MovieGenreId id) {
        this.id = id;
    }

    public Movie getMoviesMovie() {
        return moviesMovie;
    }

    public void setMoviesMovie(Movie moviesMovie) {
        this.moviesMovie = moviesMovie;
    }

    public Genre getGenresGenre() {
        return genresGenre;
    }

    public void setGenresGenre(Genre genresGenre) {
        this.genresGenre = genresGenre;
    }

}