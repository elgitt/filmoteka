package pl.polsl.filmoteka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.polsl.filmoteka.models.Episode;
import pl.polsl.filmoteka.models.Season;
import pl.polsl.filmoteka.repositories.SeasonRepository;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/seasons")

public class SeasonController {

    private final SeasonRepository seasonRepository;

    @Autowired
    public SeasonController(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @GetMapping
    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    @GetMapping("/{id}")
    public Season getSeasonById(@PathVariable Integer id) {
        return seasonRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Season addSeason(@RequestBody Season season) {
        return seasonRepository.save(season);
    }

    @PutMapping("/update")
    public Season updateSeason(@RequestBody Season season) {
        return seasonRepository.save(season);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSeason(@PathVariable Integer id) {
        seasonRepository.deleteById(id);
    }

    @GetMapping("/{id}/episodes")
    public Set<Episode> getEpisodesBySeasonId(@PathVariable Integer id) {
        Season season = seasonRepository.findById(id).orElse(null);
        return (season != null) ? season.getEpisodes() : null;
    }
}
