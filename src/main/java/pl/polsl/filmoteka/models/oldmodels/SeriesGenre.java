//package pl.polsl.filmoteka.models;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "series_genres")
//public class SeriesGenre {
//    @EmbeddedId
//    private SeriesGenreId id;
//
//    @MapsId("genresGenreId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "genres_genre_id", nullable = false)
//    private Genre genresGenre;
//
//    @MapsId("seriesSeriesId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "series_series_id", nullable = false)
//    private Series seriesSeries;
//
//    public SeriesGenreId getId() {
//        return id;
//    }
//
//    public void setId(SeriesGenreId id) {
//        this.id = id;
//    }
//
//    public Genre getGenresGenre() {
//        return genresGenre;
//    }
//
//    public void setGenresGenre(Genre genresGenre) {
//        this.genresGenre = genresGenre;
//    }
//
//    public Series getSeriesSeries() {
//        return seriesSeries;
//    }
//
//    public void setSeriesSeries(Series seriesSeries) {
//        this.seriesSeries = seriesSeries;
//    }
//
//}