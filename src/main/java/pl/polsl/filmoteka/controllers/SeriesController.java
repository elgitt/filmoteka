package pl.polsl.filmoteka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.filmoteka.repositories.SeriesRepository;

@RestController
@RequestMapping("/series")
public class SeriesController {
    private final SeriesRepository seriesRepository;

    @Autowired
    public SeriesController(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }



}