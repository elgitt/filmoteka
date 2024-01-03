package pl.polsl.filmoteka.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id", nullable = false)
    private Integer id;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "ismovie")
    private Character ismovie;

    @NotNull
    @Column(name = "users_userid", nullable = false)
    private Integer usersUserid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movies_movieid")
    private Movie moviesMovieid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_series_id")
    private Series seriesSeries;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Character getIsmovie() {
        return ismovie;
    }

    public void setIsmovie(Character ismovie) {
        this.ismovie = ismovie;
    }

    public Integer getUsersUserid() {
        return usersUserid;
    }

    public void setUsersUserid(Integer usersUserid) {
        this.usersUserid = usersUserid;
    }

    public Movie getMoviesMovieid() {
        return moviesMovieid;
    }

    public void setMoviesMovieid(Movie moviesMovieid) {
        this.moviesMovieid = moviesMovieid;
    }

    public Series getSeriesSeries() {
        return seriesSeries;
    }

    public void setSeriesSeries(Series seriesSeries) {
        this.seriesSeries = seriesSeries;
    }

}