package pl.polsl.filmoteka.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "seasons")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id", nullable = false)
    private Integer id;

    @Column(name = "season_number")
    private Integer seasonNumber;

    @Column(name = "release_year")
    private LocalDate releaseYear;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "series_series_id", nullable = false)
    @JsonBackReference  //okej
    private Series seriesSeries;

    @OneToMany(mappedBy = "seasonsSeason")
    @JsonManagedReference  //okej
    private Set<Episode> episodes = new LinkedHashSet<>();

    public Season() {
    }

    public Season(Integer id, Integer seasonNumber, LocalDate releaseYear, Series seriesSeries) {
        this.id = id;
        this.seasonNumber = seasonNumber;
        this.releaseYear = releaseYear;
        this.seriesSeries = seriesSeries;
    }

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

    public Series getSeriesSeries() {
        return seriesSeries;
    }

    public void setSeriesSeries(Series seriesSeries) {
        this.seriesSeries = seriesSeries;
    }

    public Set<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<Episode> episodes) {
        this.episodes = episodes;
    }

}