package pl.polsl.filmoteka.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tvseries")
public class Tvseries {
    @Id
    @Column(name = "tvseriesid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 255)
    @Column(name = "title")
    private String title;

    @Size(max = 100)
    @Column(name = "director", length = 100)
    private String director;

    @Lob
    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genres_genreid", nullable = false)
    private Genre genresGenreid;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "tvseries_actors",
            joinColumns = @JoinColumn(name = "tvseries_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors = new HashSet<>();

    @Column(name = "time_frame_start")
    private LocalDate timeFrameStart;

    @Column(name = "time_frame_end")
    private LocalDate timeFrameEnd;

    public LocalDate getTimeFrameEnd() {
        return timeFrameEnd;
    }

    public void setTimeFrameEnd(LocalDate timeFrameEnd) {
        this.timeFrameEnd = timeFrameEnd;
    }

    public LocalDate getTimeFrameStart() {
        return timeFrameStart;
    }

    public void setTimeFrameStart(LocalDate timeFrameStart) {
        this.timeFrameStart = timeFrameStart;
    }

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