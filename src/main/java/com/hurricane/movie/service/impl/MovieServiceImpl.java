package com.hurricane.movie.service.impl;

import com.hurricane.movie.converter.MovieDtoToEntityConverter;
import com.hurricane.movie.dto.MovieDto;
import com.hurricane.movie.repository.MovieRepository;
import com.hurricane.movie.model.Movie;
import com.hurricane.movie.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashSet;

import java.util.Set;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;
    private MovieDtoToEntityConverter movieDtoToEntityConverter;

    public MovieServiceImpl(MovieRepository movieRepository, MovieDtoToEntityConverter movieDtoToEntityConverter) {
        this.movieRepository = movieRepository;
        this.movieDtoToEntityConverter = movieDtoToEntityConverter;
    }

    @Override
    public Mono<Movie> getById(String id) {
        return movieRepository.findById(id) ;
    }

    @Override
    public Mono<Movie> create(Mono<MovieDto> movieDtoMono) {
        return movieDtoToEntityConverter.convert(movieDtoMono)
                .flatMap(movie -> movieRepository.insert(movie));
    }

    @Override
    public Flux<Movie> findAll() {
        return movieRepository.findAll();
    }
}
