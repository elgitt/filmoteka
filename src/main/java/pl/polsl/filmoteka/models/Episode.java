package pl.polsl.filmoteka.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @Column(name = "episode_id", nullable = false)
    private Integer id;

    @Column(name = "episode_number")
    private Integer episodeNumber;

    @Size(max = 100)
    @Column(name = "episode_title", length = 100)
    private String episodeTitle;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seasons_season_id", nullable = false)
    private Season seasonsSeason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Season getSeasonsSeason() {
        return seasonsSeason;
    }

    public void setSeasonsSeason(Season seasonsSeason) {
        this.seasonsSeason = seasonsSeason;
    }

}