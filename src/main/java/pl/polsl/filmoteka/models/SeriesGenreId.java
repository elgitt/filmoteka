package pl.polsl.filmoteka.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SeriesGenreId implements Serializable {
    private static final long serialVersionUID = 8195834764858854400L;
    @NotNull
    @Column(name = "genres_genre_id", nullable = false)
    private Integer genresGenreId;

    @NotNull
    @Column(name = "series_series_id", nullable = false)
    private Integer seriesSeriesId;

    public Integer getGenresGenreId() {
        return genresGenreId;
    }

    public void setGenresGenreId(Integer genresGenreId) {
        this.genresGenreId = genresGenreId;
    }

    public Integer getSeriesSeriesId() {
        return seriesSeriesId;
    }

    public void setSeriesSeriesId(Integer seriesSeriesId) {
        this.seriesSeriesId = seriesSeriesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SeriesGenreId entity = (SeriesGenreId) o;
        return Objects.equals(this.seriesSeriesId, entity.seriesSeriesId) &&
                Objects.equals(this.genresGenreId, entity.genresGenreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriesSeriesId, genresGenreId);
    }

}