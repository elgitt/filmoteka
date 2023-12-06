package pl.polsl.filmoteka.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @Column(name = "memberid", nullable = false)
    private Integer id;

    @Column(name = "name", length = 15)
    private String name;

    @Column(name = "surname", length = 20)
    private String surname;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "password", length = 20)
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}