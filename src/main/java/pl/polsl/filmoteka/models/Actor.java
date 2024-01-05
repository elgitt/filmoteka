package pl.polsl.filmoteka.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actors")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;

    @Size(max = 50)
    @Column(name = "surname", length = 50)
    private String surname;

    @Column(name = "gender")
    private Character gender;

    @Size(max = 50)
    @Column(name = "nationality", length = 50)
    private String nationality;


    @ManyToMany
    @JoinTable(name = "movie_cast",
            joinColumns = @JoinColumn(name = "actors_actor_id"))
    @JsonBackReference  //okej
    private List<Movie> movies = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "series_cast",
            joinColumns = @JoinColumn(name = "actors_actor_id"))
    @JsonBackReference  //okej
    private Set<Series> series = new LinkedHashSet<>();

    public Actor() {

    }

    public Actor(Integer id, String name, String surname, Character gender, String nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.nationality = nationality;
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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Movie> getMovies() { return movies; }

    public void setMovies(List<Movie> movies) { this.movies = movies; }

    public Set<Series> getSeries() {
        return series;
    }

    public void setSeries(Set<Series> series) {
        this.series = series;
    }

}