package com.hurricane.movie.service.impl;

import com.hurricane.movie.converter.UserDtoToEntityConverter;
import com.hurricane.movie.dto.UserDto;
import com.hurricane.movie.model.User;
import com.hurricane.movie.repository.UserRepository;
import com.hurricane.movie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserDtoToEntityConverter converter;

    public UserServiceImpl(UserRepository userRepository, UserDtoToEntityConverter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    @Override
    public Mono<User> getById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> create(Mono<UserDto> dtoMono) {
        return converter.convert(dtoMono)
                .flatMap(user -> userRepository.insert(user));
    }

    @Override
    public Mono<User> update(Mono<UserDto> dtoMono) {
        return converter.convert(dtoMono)
                .flatMap(user -> userRepository.save(user));
    }

    @Override
    public Mono<Void> delete(String id) {
        return userRepository.findById(id)
                .map(userRepository::delete)
                .then();
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}
