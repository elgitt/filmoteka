package pl.polsl.filmoteka.Models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "moviecast")
public class Moviecast {
    @EmbeddedId
    private MoviecastId id;

    public MoviecastId getId() {
        return id;
    }

    public void setId(MoviecastId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}