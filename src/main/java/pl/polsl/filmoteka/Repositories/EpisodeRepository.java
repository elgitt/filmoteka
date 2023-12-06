package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Episode;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
}