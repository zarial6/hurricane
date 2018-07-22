package com.hurricane.movie.controller;




import com.hurricane.movie.converter.MovieToDtoConverter;
import com.hurricane.movie.dto.MovieDto;
import com.hurricane.movie.model.Movie;
import com.hurricane.movie.repository.MovieRepository;
import com.hurricane.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

@RestController
public class MovieController {

    private final MovieService movieService;
    private final MovieToDtoConverter movieToDtoConverter;

    public MovieController(MovieService movieService, MovieToDtoConverter movieToDtoConverter) {
        this.movieService = movieService;
        this.movieToDtoConverter = movieToDtoConverter;
    }

    @GetMapping({"","/","/index"})
    public String getIndex()
    {

        return "Hello";

    }

    @GetMapping("/getmovie")
    public ResponseEntity<Mono<Movie>> getMovieById(@RequestParam String id)
    {
        return ResponseEntity.ok(movieService.getById(id));
    }

    @PostMapping("/createmovie")
    public ResponseEntity<Mono<MovieDto>> create(@RequestBody Mono<MovieDto> movieDtoMono){

        return ResponseEntity.ok(movieToDtoConverter.convert(movieService.create(movieDtoMono)));
    }


}
