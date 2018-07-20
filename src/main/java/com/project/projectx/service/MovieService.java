package com.project.projectx.service;


import com.project.projectx.model.Movie;


import java.util.Set;

public interface MovieService  {

    Set<Movie> getMovie();

    Movie findById(String id);

    Movie saveMovie(Movie movie);


}
