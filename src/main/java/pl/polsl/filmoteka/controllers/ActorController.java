package pl.polsl.filmoteka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.polsl.filmoteka.models.Actor;
import pl.polsl.filmoteka.models.Movie;
import pl.polsl.filmoteka.models.Series;
import pl.polsl.filmoteka.repositories.ActorRepository;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Integer id) {
        return actorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Actor addActor(@RequestBody Actor actor) {
        return actorRepository.save(actor);
    }

    @PutMapping("/{id}")
    public Actor updateActor(@PathVariable Integer id, @RequestBody Actor updatedActor) {
        return actorRepository.findById(id)
                .map(actor -> {
                    actor.setName(updatedActor.getName());
                    actor.setSurname(updatedActor.getSurname());
                    actor.setGender(updatedActor.getGender());
                    actor.setNationality(updatedActor.getNationality());
                    return actorRepository.save(actor);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Integer id) {
        actorRepository.deleteById(id);
    }

    @GetMapping("/search/{name}")
    public List<Actor> searchActorsByName(@RequestParam String name) {
        return actorRepository.findByName(name);
    }

    @GetMapping("/search/{surname}")
    public List<Actor> searchActorsBySurname(@RequestParam String sname) {
        return actorRepository.findByName(sname);
    }

    @GetMapping("/{id}/movies")
    public List<Movie> getMoviesByActorId(@PathVariable Integer id) {
        Actor actor = actorRepository.findById(id).orElse(null);
        return actor != null ? actor.getMovies() : null;
    }

    @GetMapping("/{id}/series")
    public List<Series> getTVShowsByActorId(@PathVariable Integer id) {
        Actor actor = actorRepository.findById(id).orElse(null);
        return actor != null ? actor.getSeries() : null;
    }

    @GetMapping("/series/{seriesId}")
    public List<Actor> getActorsBySeriesId(@PathVariable Integer seriesId) {
        return actorRepository.findBySeriesId(seriesId);
    }

}
