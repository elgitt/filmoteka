package pl.polsl.filmoteka.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tvseries")
public class Tvseries {
    @Id
    @Column(name = "tvseriesid", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "director", length = 100)
    private String director;

    @Column(name = "time_frame")
    private LocalDate timeFrame;

    @Lob
    @Column(name = "description")
    private String description;

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

    public LocalDate getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(LocalDate timeFrame) {
        this.timeFrame = timeFrame;
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