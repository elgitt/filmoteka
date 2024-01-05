package pl.polsl.filmoteka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.polsl.filmoteka.models.Actor;
import pl.polsl.filmoteka.models.Genre;
import pl.polsl.filmoteka.models.Season;
import pl.polsl.filmoteka.models.Series;
import pl.polsl.filmoteka.repositories.ActorRepository;
import pl.polsl.filmoteka.repositories.SeriesRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/series")

public class SeriesController {

    private final SeriesRepository seriesRepository;

    private final ActorRepository actorRepository;

    @Autowired
    public SeriesController(SeriesRepository seriesRepository, ActorRepository actorRepository) {
        this.seriesRepository = seriesRepository;
        this.actorRepository = actorRepository;
    }

    @GetMapping("/all")
    public List<Series> getAllSeries() {
        List<Series> seriesList = seriesRepository.findAll();

        for (Series series : seriesList) {
            Set<Actor> actors = actorRepository.findBySeriesId(series.getId());
            Set<Actor> fullActorSet = new HashSet<>();

            for (Actor actor : actors) {
                Actor fullActor = actorRepository.findById(actor.getId()).orElse(null);
                if (fullActor != null) {
                    fullActorSet.add(fullActor);
                }
            }

            series.setActors(fullActorSet);
        }

        return seriesList;
    }

    @GetMapping("/{id}")
    public Series getSeriesById(@PathVariable Integer id) {
        return seriesRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Series addSeries(@RequestBody Series series) {
        return seriesRepository.save(series);
    }

    @PutMapping("/update")
    public Series updateSeries(@RequestBody Series series) {
        return seriesRepository.save(series);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSeries(@PathVariable Integer id) {
        seriesRepository.deleteById(id);
    }

    @GetMapping("/{id}/actors")
    public Set<Actor> getActorsBySeriesId(@PathVariable Integer id) {
        Series series = seriesRepository.findById(id).orElse(null);
        return (series != null) ? series.getActors() : null;
    }

    @GetMapping("/{id}/genres")
    public Set<Genre> getGenresBySeriesId(@PathVariable Integer id) {
        Series series = seriesRepository.findById(id).orElse(null);
        return (series != null) ? series.getGenres() : null;
    }

    @GetMapping("/{id}/seasons")
    public Set<Season> getSeasonsBySeriesId(@PathVariable Integer id) {
        Series series = seriesRepository.findById(id).orElse(null);
        return (series != null) ? series.getSeasons() : null;
    }
}
