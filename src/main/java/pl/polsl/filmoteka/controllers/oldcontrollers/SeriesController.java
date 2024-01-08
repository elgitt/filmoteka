//package pl.polsl.filmoteka.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import pl.polsl.filmoteka.models.Actor;
//import pl.polsl.filmoteka.models.Genre;
//import pl.polsl.filmoteka.models.Season;
//import pl.polsl.filmoteka.models.Series;
//import pl.polsl.filmoteka.repositories.ActorRepository;
//import pl.polsl.filmoteka.repositories.oldrepos.SeriesRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/series")
//
//public class SeriesController {
//
//    private final SeriesRepository seriesRepository;
//
//    private final ActorRepository actorRepository;
//
//    @Autowired
//    public SeriesController(SeriesRepository seriesRepository, ActorRepository actorRepository) {
//        this.seriesRepository = seriesRepository;
//        this.actorRepository = actorRepository;
//    }
//
//    @GetMapping("/all")
//    public List<Series> getAllSeries() {
//        List<Series> seriesList = seriesRepository.findAll();
//
//        for (Series series : seriesList) {
//            List<Actor> actors = actorRepository.findBySeriesId(series.getId());
//            List<Actor> fullActorList = new ArrayList<>();
//
//            for (Actor actor : actors) {
//                Actor fullActor = actorRepository.findById(actor.getId()).orElse(null);
//                if (fullActor != null) {
//                    fullActorList.add(fullActor);
//                }
//            }
//
//            series.setActors(fullActorList);
//        }
//
//        return seriesList;
//    }
//
//    @GetMapping("/{id}")
//    public Series getSeriesById(@PathVariable Integer id) {
//        return seriesRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping("/add")
//    public Series addSeries(@RequestBody Series series) {
//        return seriesRepository.save(series);
//    }
//
//    @PutMapping("/update")
//    public Series updateSeries(@RequestBody Series series) {
//        return seriesRepository.save(series);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteSeries(@PathVariable Integer id) {
//        seriesRepository.deleteById(id);
//    }
//
//    @GetMapping("/{id}/actors")
//    public List<Actor> getActorsBySeriesId(@PathVariable Integer id) {
//        Series series = seriesRepository.findById(id).orElse(null);
//        return (series != null) ? series.getActors() : null;
//    }
//
//    @GetMapping("/{id}/genres")
//    public List<Genre> getGenresBySeriesId(@PathVariable Integer id) {
//        Series series = seriesRepository.findById(id).orElse(null);
//        return (series != null) ? series.getGenres() : null;
//    }
//
//    @GetMapping("/{id}/seasons")
//    public List<Season> getSeasonsBySeriesId(@PathVariable Integer id) {
//        Series series = seriesRepository.findById(id).orElse(null);
//        return (series != null) ? series.getSeasons() : null;
//    }
//}
