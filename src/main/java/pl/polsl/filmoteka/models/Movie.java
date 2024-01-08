package pl.polsl.filmoteka.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

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

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "movies")
    @JsonManagedReference  //okej
    private List<Actor> actors = new ArrayList<>();

    @ManyToMany(mappedBy = "movies")
    @JsonManagedReference  //okej
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "moviesMovie")
    @JsonBackReference  //okej
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "moviesMovie")
    @JsonBackReference  //okej
    private List<Watchlist> watchlists = new ArrayList<>();

    @Lob
    @Column(name = "type")
    private String type;

    @Column(name = "seasons")
    private Integer seasons;

    @Size(max = 100)
    @Column(name = "duration", length = 100)
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Movie() {
    }

    public Movie(Integer id, String posterLink, String title, String director, Integer releaseYear, String duration, String description, List<Actor> actors, List<Genre> genres) {
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


    public List<Watchlist> getWatchlists() {
        return watchlists;
    }

    public void setWatchlists(List<Watchlist> watchlists) {
        this.watchlists = watchlists;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}