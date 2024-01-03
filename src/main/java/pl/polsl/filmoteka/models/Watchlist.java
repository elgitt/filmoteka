package pl.polsl.filmoteka.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "watchlists")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watchlist_id", nullable = false)
    private Integer id;

    @Column(name = "ismovie")
    private Character ismovie;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "users_userid", nullable = false)
    private User usersUserid;

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

    public Character getIsmovie() {
        return ismovie;
    }

    public void setIsmovie(Character ismovie) {
        this.ismovie = ismovie;
    }

    public User getUsersUserid() {
        return usersUserid;
    }

    public void setUsersUserid(User usersUserid) {
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