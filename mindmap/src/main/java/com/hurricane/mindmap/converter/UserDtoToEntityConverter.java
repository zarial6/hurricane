package com.hurricane.mindmap.converter;

import com.hurricane.mindmap.dto.UserDto;
import com.hurricane.mindmap.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserDtoToEntityConverter implements Converter<Mono<UserDto>, Mono<User>> {

    @Override
    public Mono<User> convert(Mono<UserDto> dtoMono) {
        return dtoMono.map(dto -> {
            User user = User.builder()
                    .firstName(dto.getFirstName())
                    .lastName(dto.getLastName())
                    .email(dto.getEmail())
                    .login(dto.getLogin())
                    .password(dto.getPassword())
                    .build();
            user.setId(user.getId());

            return user;
        });
    }
}
