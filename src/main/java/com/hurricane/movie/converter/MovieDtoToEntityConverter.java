package com.hurricane.movie.converter;

import com.hurricane.movie.dto.MovieDto;
import com.hurricane.movie.model.Movie;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MovieDtoToEntityConverter implements Converter<Mono<MovieDto>, Mono<Movie>> {

    @Override
    public Mono<Movie> convert(Mono<MovieDto> movieDtoMono) {
        return movieDtoMono.map(movieDto -> {
            Movie movie = Movie.builder()
                    .title(movieDto.getTitle())
                    .director(movieDto.getDirector())
                    .year(movieDto.getYear())
                    .rating(movieDto.getRating())
                    .build();
            movie.setId(movie.getId());

            return movie;

        });
    }

}


