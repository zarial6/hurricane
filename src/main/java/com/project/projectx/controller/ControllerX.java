package com.project.projectx.controller;




import com.project.projectx.repository.MovieRepository;
import com.project.projectx.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerX {

    private final MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    public ControllerX(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping({"","/","/index"})
    public String getIndex(Model model)
    {

        model.addAttribute("movies",movieService.getMovie());


        return "index";




    }



}
