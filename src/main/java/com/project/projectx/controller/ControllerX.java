package com.project.projectx.controller;




import com.project.projectx.model.Movie;
import com.project.projectx.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ControllerX {



    @Autowired
    private MovieRepository movieRepository;



    @GetMapping({"","/","/index"})
    public Mono<Movie> getIndex(@RequestParam String id)
    {



        return movieRepository.findById(id);




    }



}
