package pl.polsl.filmoteka.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "watchlists")
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watchlist_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movies_movie_id")
    @JsonManagedReference
    private Movie moviesMovie;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_user_id", nullable = false)
    @JsonBackReference
    private User usersUser;

//    @Nullable
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "series_series_id")
//    @JsonManagedReference  //okej
//    private Series seriesSeries;

//    @NotNull
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "users_user_id")
//    @JsonBackReference //okej
//    private User usersUser;

//    @Nullable
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "movies_movie_id")
//    @JsonManagedReference //okej
//    private Movie moviesMovie;




    public Watchlist() {
    }

    public Watchlist(Integer id,  User usersUser, Movie moviesMovie) {
        this.id = id;
       // this.seriesSeries = seriesSeries;
        this.usersUser = usersUser;
        this.moviesMovie = moviesMovie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public User getUsersUser() {
        return usersUser;
    }

    public void setUsersUser(User usersUser) {
        this.usersUser = usersUser;
    }

    public Movie getMoviesMovie() {
        return moviesMovie;
    }

    public void setMoviesMovie(Movie moviesMovie) {
        this.moviesMovie = moviesMovie;
    }


//    public Series getSeriesSeries() {
//        return seriesSeries;
//    }
//
//    public void setSeriesSeries(Series seriesSeries) {
//        this.seriesSeries = seriesSeries;
//    }


}