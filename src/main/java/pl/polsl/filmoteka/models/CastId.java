package pl.polsl.filmoteka.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CastId implements Serializable {
    private static final long serialVersionUID = -2554502675517924929L;
    @NotNull
    @Column(name = "movies_movie_id", nullable = false)
    private Integer moviesMovieId;

    @NotNull
    @Column(name = "actors_actor_id", nullable = false)
    private Integer actorsActorId;

    public Integer getMoviesMovieId() {
        return moviesMovieId;
    }

    public void setMoviesMovieId(Integer moviesMovieId) {
        this.moviesMovieId = moviesMovieId;
    }

    public Integer getActorsActorId() {
        return actorsActorId;
    }

    public void setActorsActorId(Integer actorsActorId) {
        this.actorsActorId = actorsActorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CastId entity = (CastId) o;
        return Objects.equals(this.moviesMovieId, entity.moviesMovieId) &&
                Objects.equals(this.actorsActorId, entity.actorsActorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moviesMovieId, actorsActorId);
    }

}