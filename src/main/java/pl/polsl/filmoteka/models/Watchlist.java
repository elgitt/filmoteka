package pl.polsl.filmoteka.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "watchlists")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watchlist_id", nullable = false)
    private Integer id;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_series_id")
    @JsonManagedReference  //okej
    private Series seriesSeries;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_user_id")
    @JsonBackReference //okej
    private User usersUser;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movies_movie_id")
    @JsonManagedReference //okej
    private Movie moviesMovie;

    @Column(name = "movie_series_id")
    private Integer movieSeriesId;

    @Lob
    @Column(name = "movie_series_type")
    private String movieSeriesType;


    public Watchlist() {
    }

    public Watchlist(Integer id, Series seriesSeries, User usersUser, Movie moviesMovie) {
        this.id = id;
        this.seriesSeries = seriesSeries;
        this.usersUser = usersUser;
        this.moviesMovie = moviesMovie;
    }

    public Movie getMoviesMovie() {
        return moviesMovie;
    }

    public void setMoviesMovie(Movie moviesMovie) {
        this.moviesMovie = moviesMovie;
    }

    public User getUsersUser() {
        return usersUser;
    }

    public void setUsersUser(User usersUser) {
        this.usersUser = usersUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Series getSeriesSeries() {
        return seriesSeries;
    }

    public void setSeriesSeries(Series seriesSeries) {
        this.seriesSeries = seriesSeries;
    }
    public String getMovieSeriesType() {
        return movieSeriesType;
    }

    public void setMovieSeriesType(String movieSeriesType) {
        this.movieSeriesType = movieSeriesType;
    }

    public Integer getMovieSeriesId() {
        return movieSeriesId;
    }

    public void setMovieSeriesId(Integer movieSeriesId) {
        this.movieSeriesId = movieSeriesId;
    }

}