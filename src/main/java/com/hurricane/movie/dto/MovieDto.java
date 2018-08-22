package com.hurricane.movie.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto extends BaseDto {

    private String title;
    private String director;
    private String year;
    private String rating;


}
