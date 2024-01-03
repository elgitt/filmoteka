package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
}