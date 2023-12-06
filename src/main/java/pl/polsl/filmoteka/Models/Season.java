package pl.polsl.filmoteka.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @Column(name = "seasonid", nullable = false)
    private Integer id;

    @Column(name = "season_number")
    private Integer seasonNumber;

    @Column(name = "release_year")
    private LocalDate releaseYear;

    @Column(name = "tvseries_tvseriesid", nullable = false)
    private Integer tvseriesTvseriesid;

    @OneToMany(mappedBy = "seasonsSeasonid")
    private Set<Episode> episodes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getTvseriesTvseriesid() {
        return tvseriesTvseriesid;
    }

    public void setTvseriesTvseriesid(Integer tvseriesTvseriesid) {
        this.tvseriesTvseriesid = tvseriesTvseriesid;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

}