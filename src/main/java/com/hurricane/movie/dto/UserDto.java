package com.hurricane.movie.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto extends BaseDto {

    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
}
