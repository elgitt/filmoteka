package pl.polsl.filmoteka.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cast", schema = "mydb")
public class Cast {
    @EmbeddedId
    private CastId id;

    @MapsId("moviesMovieId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movies_movie_id", nullable = false)
    private Movie moviesMovie;

    @MapsId("actorsActorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actors_actor_id", nullable = false)
    private Actor actorsActor;

    public CastId getId() {
        return id;
    }

    public void setId(CastId id) {
        this.id = id;
    }

    public Movie getMoviesMovie() {
        return moviesMovie;
    }

    public void setMoviesMovie(Movie moviesMovie) {
        this.moviesMovie = moviesMovie;
    }

    public Actor getActorsActor() {
        return actorsActor;
    }

    public void setActorsActor(Actor actorsActor) {
        this.actorsActor = actorsActor;
    }

}