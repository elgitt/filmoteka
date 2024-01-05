package pl.polsl.filmoteka.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "genre", length = 50)
    private String genre;

    @ManyToMany
    @JoinTable(name = "movie_genres",
            joinColumns = @JoinColumn(name = "genres_genre_id"))
   // @JsonBackReference  //okej
    private Set<Movie> movies = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "series_genres",
            joinColumns = @JoinColumn(name = "genres_genre_id"))
    @JsonBackReference //okej
    private Set<Series> series = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "genres")
    @JsonBackReference //okej
    private Set<User> users = new LinkedHashSet<>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
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

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Set<Series> getSeries() {
        return series;
    }

    public void setSeries(Set<Series> series) {
        this.series = series;
    }

}