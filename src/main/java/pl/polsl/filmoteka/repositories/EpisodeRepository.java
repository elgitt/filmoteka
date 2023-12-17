package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.models.Episode;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
}