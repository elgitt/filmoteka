package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.models.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}