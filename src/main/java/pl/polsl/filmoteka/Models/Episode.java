package pl.polsl.filmoteka.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @Column(name = "episodeid", nullable = false)
    private Integer id;

    @Column(name = "episode_number")
    private Integer episodeNumber;

    @Column(name = "episode_title", length = 100)
    private String episodeTitle;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seasons_seasonid", nullable = false)
    private Season seasonsSeasonid;

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

    public Season getSeasonsSeasonid() {
        return seasonsSeasonid;
    }

    public void setSeasonsSeasonid(Season seasonsSeasonid) {
        this.seasonsSeasonid = seasonsSeasonid;
    }

}