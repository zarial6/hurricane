package com.project.projectx.service;

import com.project.projectx.model.Movie;
import com.project.projectx.repository.MovieRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashSet;

import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService{

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
    public Movie findById(String id) {
        Mono<Movie> movie = movieRepository.findById(id);
        return movie.block();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return null;
    }
}
