package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}