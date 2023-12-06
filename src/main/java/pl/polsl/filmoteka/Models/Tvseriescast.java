package pl.polsl.filmoteka.Models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tvseriescast")
public class Tvseriescast {
    @EmbeddedId
    private TvseriescastId id;

    public TvseriescastId getId() {
        return id;
    }

    public void setId(TvseriescastId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}