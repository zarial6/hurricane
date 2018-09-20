package com.hurricane.mindmap.service.impl;

import com.hurricane.mindmap.repository.MovieRepository;
import com.hurricane.mindmap.model.Movie;
import com.hurricane.mindmap.service.MovieService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashSet;

import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Set<Movie> getMovie() {

        Set<Movie> movies = new HashSet<>();
        movieRepository.findAll();
        return movies;

    }

    @Override
    public Mono<Movie> findById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public Mono<Movie> saveMovie(Movie movie) {
        return null;
    }
}
