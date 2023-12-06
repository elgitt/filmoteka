package pl.polsl.filmoteka.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "watchlists")
public class Watchlist {
    @Id
    @Column(name = "watchlistid", nullable = false)
    private Integer id;

    @Column(name = "ismovie")
    private Character ismovie;

    @Column(name = "members_memberid", nullable = false)
    private Integer membersMemberid;

    @Column(name = "tvseries_tvseriesid")
    private Integer tvseriesTvseriesid;

    @Column(name = "movies_movieid")
    private Integer moviesMovieid;

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

    public Integer getMembersMemberid() {
        return membersMemberid;
    }

    public void setMembersMemberid(Integer membersMemberid) {
        this.membersMemberid = membersMemberid;
    }

    public Integer getTvseriesTvseriesid() {
        return tvseriesTvseriesid;
    }

    public void setTvseriesTvseriesid(Integer tvseriesTvseriesid) {
        this.tvseriesTvseriesid = tvseriesTvseriesid;
    }

    public Integer getMoviesMovieid() {
        return moviesMovieid;
    }

    public void setMoviesMovieid(Integer moviesMovieid) {
        this.moviesMovieid = moviesMovieid;
    }

}