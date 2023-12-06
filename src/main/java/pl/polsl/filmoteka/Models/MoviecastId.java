package pl.polsl.filmoteka.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MoviecastId implements Serializable {
    private static final long serialVersionUID = 1609675832939723174L;
    @Column(name = "movies_movieid", nullable = false)
    private Integer moviesMovieid;

    @Column(name = "actors_actorid", nullable = false)
    private Integer actorsActorid;

    public Integer getMoviesMovieid() {
        return moviesMovieid;
    }

    public void setMoviesMovieid(Integer moviesMovieid) {
        this.moviesMovieid = moviesMovieid;
    }

    public Integer getActorsActorid() {
        return actorsActorid;
    }

    public void setActorsActorid(Integer actorsActorid) {
        this.actorsActorid = actorsActorid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MoviecastId entity = (MoviecastId) o;
        return Objects.equals(this.moviesMovieid, entity.moviesMovieid) &&
                Objects.equals(this.actorsActorid, entity.actorsActorid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moviesMovieid, actorsActorid);
    }

}