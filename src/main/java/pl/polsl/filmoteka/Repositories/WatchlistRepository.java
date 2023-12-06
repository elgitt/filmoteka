package pl.polsl.filmoteka.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.filmoteka.Models.Watchlist;

public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {
}