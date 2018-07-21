package com.hurricane.movie.converter;

import com.hurricane.movie.dto.UserDto;
import com.hurricane.movie.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserToDtoConverter implements Converter<Mono<User>, Mono<UserDto>> {

    @Override
    public Mono<UserDto> convert(Mono<User> userMono) {
        return userMono.map(user -> {
            UserDto dto = UserDto.builder()
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .email(user.getEmail())
                    .login(user.getLogin())
                    .build();
            dto.setId(user.getId());

            return dto;
        });
    }
}
