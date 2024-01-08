package pl.polsl.filmoteka.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "genre", length = 50)
    private String genre;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "movie_genres",
//            joinColumns = @JoinColumn(name = "genres_genre_id"))
//    @JsonBackReference  //okej
//    private List<Movie> movies = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(name = "series_genres",
//            joinColumns = @JoinColumn(name = "genres_genre_id"))
//    @JsonBackReference //okej
//    private List<Series> series = new ArrayList<>();

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference //okej
    private List<User> users = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movies_genres",
            joinColumns = @JoinColumn(name = "genres_genre_id"))
            //inverseJoinColumns = @JoinColumn(name = "movies_movie_id"))
    @JsonBackReference
    private List<Movie> movies = new ArrayList<>();


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Genre() {
    }

    public Genre(Integer id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

//    public List<Series> getSeries() {
//        return series;
//    }
//
//    public void setSeries(List<Series> series) {
//        this.series = series;
//    }

}