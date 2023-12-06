package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Tvseriescast;
import pl.polsl.filmoteka.Models.TvseriescastId;

public interface TvseriescastRepository extends JpaRepository<Tvseriescast, TvseriescastId> {
}