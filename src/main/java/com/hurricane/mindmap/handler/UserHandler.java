package com.hurricane.mindmap.handler;

import com.hurricane.mindmap.converter.UserToDtoConverter;
import com.hurricane.mindmap.dto.UserDto;
import com.hurricane.mindmap.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.*;
import static org.springframework.web.util.UriComponentsBuilder.fromPath;

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
        return Optional.of(request.pathVariable("id"))
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
        return userService.create(request.bodyToMono(UserDto.class))
                .flatMap(user -> created(fromPath("user/".concat(user.getId())).build().toUri())
                        .contentType(APPLICATION_JSON)
                        .body(fromPublisher(userToDtoConverter.convert(user), UserDto.class))
                ).switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        return userService.update(request.bodyToMono(UserDto.class))
                .flatMap(createdUser -> created(fromPath("user/".concat(createdUser.getId())).build().toUri())
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(userToDtoConverter.convert(createdUser), UserDto.class))
        ).switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return noContent()
                .build(userService.delete(request.pathVariable("id")))
                .switchIfEmpty(notFound().build());
    }
}
