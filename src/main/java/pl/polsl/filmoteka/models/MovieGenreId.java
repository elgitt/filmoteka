package pl.polsl.filmoteka.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieGenreId implements Serializable {
    private static final long serialVersionUID = -3221361168789642375L;
    @NotNull
    @Column(name = "movies_movie_id", nullable = false)
    private Integer moviesMovieId;

    @NotNull
    @Column(name = "genres_genre_id", nullable = false)
    private Integer genresGenreId;

    public Integer getMoviesMovieId() {
        return moviesMovieId;
    }

    public void setMoviesMovieId(Integer moviesMovieId) {
        this.moviesMovieId = moviesMovieId;
    }

    public Integer getGenresGenreId() {
        return genresGenreId;
    }

    public void setGenresGenreId(Integer genresGenreId) {
        this.genresGenreId = genresGenreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MovieGenreId entity = (MovieGenreId) o;
        return Objects.equals(this.moviesMovieId, entity.moviesMovieId) &&
                Objects.equals(this.genresGenreId, entity.genresGenreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moviesMovieId, genresGenreId);
    }

}