package com.hurricane.mindmap.service;


import com.hurricane.mindmap.model.Movie;
import reactor.core.publisher.Mono;


import java.util.Set;

public interface MovieService  {

    Set<Movie> getMovie();

    Mono<Movie> findById(String id);

    Mono<Movie> saveMovie(Movie movie);


}
