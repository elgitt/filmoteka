package pl.polsl.filmoteka.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @Column(name = "seasonid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "season_number")
    private Integer seasonNumber;

    @Column(name = "release_year")
    private LocalDate releaseYear;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tvseries_tvseriesid", nullable = false)
    private Tvseries tvseriesTvseriesid;

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

    public Tvseries getTvseriesTvseriesid() {
        return tvseriesTvseriesid;
    }

    public void setTvseriesTvseriesid(Tvseries tvseriesTvseriesid) {
        this.tvseriesTvseriesid = tvseriesTvseriesid;
    }

}