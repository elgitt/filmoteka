package pl.polsl.filmoteka.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Size(max = 60)
    @Column(name = "name", length = 60)
    private String name;

    @Size(max = 60)
    @Column(name = "surname", length = 60)
    private String surname;

    @Size(max = 60)
    @Column(name = "username", length = 60)
    private String username;

    @Size(max = 60)
    @Column(name = "password", length = 60)
    private String password;

    @Size(max = 10)
    @NotNull
    @Column(name = "role", nullable = false, length = 10)
    private String role;

    @ManyToMany
    @JoinTable(name = "user_genre_preferences",
            joinColumns = @JoinColumn(name = "users_user_id"))
    @JsonManagedReference  //okej
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "usersUser")
    @JsonManagedReference  //okej
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "usersUser")
    @JsonManagedReference  //okej
    private List<Watchlist> watchlists = new ArrayList<>();

    public User() {
    }

    public User(Integer id, String name, String surname, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public List<Watchlist> getWatchlists() {
        return watchlists;
    }

    public void setWatchlists(List<Watchlist> watchlists) {
        this.watchlists = watchlists;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }


}