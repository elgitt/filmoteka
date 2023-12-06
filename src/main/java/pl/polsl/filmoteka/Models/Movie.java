package pl.polsl.filmoteka.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @Column(name = "movieid", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "director", length = 100)
    private String director;

    @Column(name = "release_year")
    private LocalDate releaseYear;

    @Column(name = "duration")
    private LocalTime duration;

    @Lob
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genres_genreid")
    private Genre genresGenreid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
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

    public Genre getGenresGenreid() {
        return genresGenreid;
    }

    public void setGenresGenreid(Genre genresGenreid) {
        this.genresGenreid = genresGenreid;
    }

}