package pl.polsl.filmoteka.Models;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @Column(name = "genreid", nullable = false)
    private Integer id;

    @Column(name = "genre", length = 50)
    private String genre;

    @Column(name = "genreid1")
    private Integer genreid1;

    @OneToMany(mappedBy = "genresGenreid")
    private Set<Movie> movies = new LinkedHashSet<>();

    @OneToMany(mappedBy = "genresGenreid")
    private Set<Tvseries> tvseries = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getGenreid1() {
        return genreid1;
    }

    public void setGenreid1(Integer genreid1) {
        this.genreid1 = genreid1;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<Tvseries> getTvseries() {
        return tvseries;
    }

    public void setTvseries(Set<Tvseries> tvseries) {
        this.tvseries = tvseries;
    }

}