package pl.polsl.filmoteka.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "series")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id", nullable = false)
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

    @Column(name = "time_frame_start")
    private LocalDate timeFrameStart;

    @Column(name = "time_frame_end")
    private LocalDate timeFrameEnd;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "series")
    @JsonManagedReference //okej
    private List<Actor> actors = new ArrayList<>();

    @ManyToMany(mappedBy = "series")
    @JsonManagedReference //okej
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "seriesSeries")
    @JsonBackReference  //okej
    private List<Watchlist> watchlists = new ArrayList<>();

    @OneToMany(mappedBy = "seriesSeries")
    @JsonBackReference //okej
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "seriesSeries")
    @JsonManagedReference //okej
    private List<Season> seasons = new ArrayList<>();

    public Series() {
    }

    public Series(Integer id, String posterLink, String title, String director, LocalDate timeFrameStart, LocalDate timeFrameEnd, String description,  List<Actor> actors, List<Genre> genres,  List<Season> seasons) {
        this.id = id;
        this.posterLink = posterLink;
        this.title = title;
        this.director = director;
        this.timeFrameStart = timeFrameStart;
        this.timeFrameEnd = timeFrameEnd;
        this.description = description;
        this.actors = actors;
        this.genres = genres;
        this.seasons = seasons;
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

    public LocalDate getTimeFrameStart() {
        return timeFrameStart;
    }

    public void setTimeFrameStart(LocalDate timeFrameStart) {
        this.timeFrameStart = timeFrameStart;
    }

    public LocalDate getTimeFrameEnd() {
        return timeFrameEnd;
    }

    public void setTimeFrameEnd(LocalDate timeFrameEnd) {
        this.timeFrameEnd = timeFrameEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
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

    public List<Watchlist> getWatchlists() {
        return watchlists;
    }

    public void setWatchlists(List<Watchlist> watchlists) {
        this.watchlists = watchlists;
    }

}