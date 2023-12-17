package pl.polsl.filmoteka.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @Column(name = "ratingid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "ismovie")
    private Character ismovie;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_userId", nullable = false)
    private User usersUser;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movies_movieid", nullable = false)
    private Movie moviesMovieid;

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

    public User getUsersUser() {
        return usersUser;
    }

    public void setUsersUser(User usersUser) {
        this.usersUser = usersUser;
    }

    public Movie getMoviesMovieid() {
        return moviesMovieid;
    }

    public void setMoviesMovieid(Movie moviesMovieid) {
        this.moviesMovieid = moviesMovieid;
    }

    public Tvseries getTvseriesTvseriesid() {
        return tvseriesTvseriesid;
    }

    public void setTvseriesTvseriesid(Tvseries tvseriesTvseriesid) {
        this.tvseriesTvseriesid = tvseriesTvseriesid;
    }

}