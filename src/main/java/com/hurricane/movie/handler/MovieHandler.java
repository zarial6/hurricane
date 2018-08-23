package com.hurricane.movie.handler;


import com.hurricane.movie.converter.MovieToDtoConverter;
import com.hurricane.movie.dto.MovieDto;
import com.hurricane.movie.model.Movie;
import com.hurricane.movie.service.MovieService;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;



import static org.springframework.http.MediaType.APPLICATION_JSON;


import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.*;


@Component
public class MovieHandler {

    private final MovieService movieService;
    private final MovieToDtoConverter movieToDtoConverter;

    public MovieHandler(MovieService movieService, MovieToDtoConverter movieToDtoConverter) {
        this.movieService = movieService;
        this.movieToDtoConverter = movieToDtoConverter;
    }


    public Mono<ServerResponse> getById(ServerRequest request) {
        return request.queryParam("id")
                .map(movieService::getById)
                .map(movie -> ok().contentType(APPLICATION_JSON)
                        .body(fromPublisher(movie.flatMap(movieToDtoConverter::convert), MovieDto.class))
                        .switchIfEmpty(notFound().build())
                ).orElse(badRequest().build());
    }

   public Mono<ServerResponse> findAll(ServerRequest request)
   {
       return ok().contentType(APPLICATION_JSON)
               .body(fromPublisher(movieService.findAll(), Movie.class));

   }

   public Mono<ServerResponse> create(ServerRequest request)
   {
        Mono<MovieDto> movieDtoMono = request.bodyToMono(MovieDto.class);
        Mono<Movie> movieMono = movieService.create(movieDtoMono);
        return movieMono.flatMap(movie -> created(UriComponentsBuilder.fromPath("/movie".concat(movie.getId())).build().toUri())
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(movieMono.flatMap(movieToDtoConverter::convert), MovieDto.class))
                .switchIfEmpty(notFound().build()));


   }


}
