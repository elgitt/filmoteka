package pl.polsl.filmoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.models.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
}