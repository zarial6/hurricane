package com.hurricane.movie.controller;




import com.hurricane.movie.repository.MovieRepository;
import com.hurricane.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping({"","/","/index"})
    public String getIndex(Model model)
    {

        model.addAttribute("movies",movieService.getMovie());


        return "index";




    }



}
