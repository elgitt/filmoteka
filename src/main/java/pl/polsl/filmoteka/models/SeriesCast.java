package pl.polsl.filmoteka.models;

import jakarta.persistence.*;

@Entity
@Table(name = "series_cast")
public class SeriesCast {
    @EmbeddedId
    private SeriesCastId id;

    @MapsId("actorsActorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actors_actor_id", nullable = false)
    private Actor actorsActor;

    @MapsId("seriesSeriesId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "series_series_id", nullable = false)
    private Series seriesSeries;

    public SeriesCastId getId() {
        return id;
    }

    public void setId(SeriesCastId id) {
        this.id = id;
    }

    public Actor getActorsActor() {
        return actorsActor;
    }

    public void setActorsActor(Actor actorsActor) {
        this.actorsActor = actorsActor;
    }

    public Series getSeriesSeries() {
        return seriesSeries;
    }

    public void setSeriesSeries(Series seriesSeries) {
        this.seriesSeries = seriesSeries;
    }

}