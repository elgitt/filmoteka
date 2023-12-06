package pl.polsl.filmoteka.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TvseriescastId implements Serializable {
    private static final long serialVersionUID = -9033454268905523756L;
    @Column(name = "actors_actorid", nullable = false)
    private Integer actorsActorid;

    @Column(name = "tvseries_tvseriesid", nullable = false)
    private Integer tvseriesTvseriesid;

    public Integer getActorsActorid() {
        return actorsActorid;
    }

    public void setActorsActorid(Integer actorsActorid) {
        this.actorsActorid = actorsActorid;
    }

    public Integer getTvseriesTvseriesid() {
        return tvseriesTvseriesid;
    }

    public void setTvseriesTvseriesid(Integer tvseriesTvseriesid) {
        this.tvseriesTvseriesid = tvseriesTvseriesid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TvseriescastId entity = (TvseriescastId) o;
        return Objects.equals(this.actorsActorid, entity.actorsActorid) &&
                Objects.equals(this.tvseriesTvseriesid, entity.tvseriesTvseriesid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorsActorid, tvseriesTvseriesid);
    }

}