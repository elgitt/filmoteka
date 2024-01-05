package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
   /* List<Rating> findByUsersUser(User user);

    Rating findByUsersUserAndSeriesSeriesId(User user, Series series);


    Rating findByUsersUserAndMoviesMovieid(User user, Movie movie);*/

}