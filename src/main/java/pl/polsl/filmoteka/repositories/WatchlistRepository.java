package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.filmoteka.models.Watchlist;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
}