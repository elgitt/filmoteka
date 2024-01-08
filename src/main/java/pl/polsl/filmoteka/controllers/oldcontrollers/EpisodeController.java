//package pl.polsl.filmoteka.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import pl.polsl.filmoteka.models.Episode;
//import pl.polsl.filmoteka.repositories.oldrepos.EpisodeRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/episodes")
//
//public class EpisodeController {
//
//    private final EpisodeRepository episodeRepository;
//
//    @Autowired
//    public EpisodeController(EpisodeRepository episodeRepository) {
//        this.episodeRepository = episodeRepository;
//    }
//
//    @GetMapping
//    public List<Episode> getAllEpisodes() {
//        return episodeRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Episode getEpisodeById(@PathVariable Integer id) {
//        return episodeRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping("/add")
//    public Episode addEpisode(@RequestBody Episode episode) {
//        return episodeRepository.save(episode);
//    }
//
//    @PutMapping("/update")
//    public Episode updateEpisode(@RequestBody Episode episode) {
//        return episodeRepository.save(episode);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteEpisode(@PathVariable Integer id) {
//        episodeRepository.deleteById(id);
//    }
//}
