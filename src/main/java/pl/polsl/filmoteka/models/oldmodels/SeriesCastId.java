//package pl.polsl.filmoteka.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//import jakarta.validation.constraints.NotNull;
//import org.hibernate.Hibernate;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class SeriesCastId implements Serializable {
//    private static final long serialVersionUID = -7004149476527221722L;
//    @NotNull
//    @Column(name = "actors_actor_id", nullable = false)
//    private Integer actorsActorId;
//
//    @NotNull
//    @Column(name = "series_series_id", nullable = false)
//    private Integer seriesSeriesId;
//
//    public Integer getActorsActorId() {
//        return actorsActorId;
//    }
//
//    public void setActorsActorId(Integer actorsActorId) {
//        this.actorsActorId = actorsActorId;
//    }
//
//    public Integer getSeriesSeriesId() {
//        return seriesSeriesId;
//    }
//
//    public void setSeriesSeriesId(Integer seriesSeriesId) {
//        this.seriesSeriesId = seriesSeriesId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        SeriesCastId entity = (SeriesCastId) o;
//        return Objects.equals(this.seriesSeriesId, entity.seriesSeriesId) &&
//                Objects.equals(this.actorsActorId, entity.actorsActorId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(seriesSeriesId, actorsActorId);
//    }
//
//}