package com.hurricane.movie.converter;


import com.hurricane.movie.dto.MovieDto;
import com.hurricane.movie.model.Movie;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MovieToDtoConverter implements Converter<Movie, Mono<MovieDto>> {


    @Override
    public Mono<MovieDto> convert(Movie movie) {

                MovieDto movieDto = MovieDto.builder()
                        .title(movie.getTitle())
                        .director(movie.getDirector())
                        .year(movie.getYear())
                        .rating(movie.getRating())
                        .build();
                movieDto.setId(movie.getId());

                return Mono.just(movieDto);

    }
}
