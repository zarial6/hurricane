package com.hurricane.mindmap.service;

import com.hurricane.mindmap.dto.UserDto;
import com.hurricane.mindmap.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> getById(String id);

    Mono<User> create(Mono<UserDto> dtoMono);

    Mono<User> update(Mono<UserDto> dtoMono);

    Mono<Void> delete(String id);

    Flux<User> findAll();
}
