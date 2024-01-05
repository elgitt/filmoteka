package pl.polsl.filmoteka.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "poster_link")
    private String posterLink;

    @Size(max = 255)
    @Column(name = "title")
    private String title;

    @Size(max = 100)
    @Column(name = "director", length = 100)
    private String director;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "duration")
    private LocalTime duration;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "movies")
    @JsonManagedReference  //okej
    private List<Actor> actors = new ArrayList<>();

    @ManyToMany(mappedBy = "movies")
    //   @JsonManagedReference  //okej
    private Set<Genre> genres = new LinkedHashSet<>();

    @OneToMany(mappedBy = "moviesMovie")
    @JsonBackReference  //okej
    private Set<Rating> ratings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "moviesMovie")
    @JsonBackReference  //okej
    private Set<Watchlist> watchlists = new LinkedHashSet<>();

    public Movie() {
    }

    public Movie(Integer id, String posterLink, String title, String director, Integer releaseYear, LocalTime duration, String description, List<Actor> actors, Set<Genre> genres) {
        this.id = id;
        this.posterLink = posterLink;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.description = description;
        this.actors = actors;
        this.genres = genres;
    }


    public Set<Watchlist> getWatchlists() {
        return watchlists;
    }

    public void setWatchlists(Set<Watchlist> watchlists) {
        this.watchlists = watchlists;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

}