package pl.polsl.filmoteka.repositories;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Movie;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {


    @Override
    @EntityGraph(attributePaths = {"actors", "genres"})
    List<Movie> findAll();

    List<Movie> findByReleaseYear(Integer releaseYear);
    List<Movie> findByTitle(String title);


}