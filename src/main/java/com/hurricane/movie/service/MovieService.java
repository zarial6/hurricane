package com.hurricane.movie.service;


import com.hurricane.movie.dto.MovieDto;
import com.hurricane.movie.model.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.Set;

public interface MovieService  {

    Mono<Movie> getById(String id);

    Mono<Movie> create(Mono<MovieDto> movieDtoMono);

    Flux<Movie> findAll();


}
