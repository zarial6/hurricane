package com.hurricane.movie.handler;

import com.hurricane.movie.converter.UserToDtoConverter;
import com.hurricane.movie.dto.UserDto;
import com.hurricane.movie.model.User;
import com.hurricane.movie.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

/**
 * @author Oleg Zhymolokhov (oleg.zhimolokhov@dataart.com)
 */

@Component
public class UserHandler {

    private UserService userService;
    private UserToDtoConverter userToDtoConverter;

    public UserHandler(UserService userService, UserToDtoConverter userToDtoConverter) {
        this.userService = userService;
        this.userToDtoConverter = userToDtoConverter;
    }

    public Mono<ServerResponse> getById(ServerRequest request) {
        return request.queryParam("id")
                .map(userService::getById)
                .map(user -> ok().contentType(APPLICATION_JSON)
                        .body(fromPublisher(user.flatMap(userToDtoConverter::convert), UserDto.class))
                        .switchIfEmpty(notFound().build())
                ).orElse(badRequest().build());
    }

    public Mono<ServerResponse> all(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(fromPublisher(userService.findAll().flatMap(user -> userToDtoConverter.convert(user)), UserDto.class))
                .switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<UserDto> dtoMono = request.bodyToMono(UserDto.class);
        Mono<User> userMono = userService.create(dtoMono);
        return userMono.flatMap(user -> created(UriComponentsBuilder.fromPath("user/".concat(user.getId())).build().toUri())
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(userMono.flatMap(userToDtoConverter::convert), UserDto.class))
        ).switchIfEmpty(notFound().build());
    }
}
