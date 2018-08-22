package com.hurricane.movie.controller;

import com.hurricane.movie.converter.UserToDtoConverter;
import com.hurricane.movie.dto.UserDto;
import com.hurricane.movie.model.User;
import com.hurricane.movie.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/user")
public class UserController {

    /*private UserService userService;
    private UserToDtoConverter userToDtoConverter;

    public UserController(UserService userService, UserToDtoConverter userToDtoConverter) {
        this.userService = userService;
        this.userToDtoConverter = userToDtoConverter;
    }

    @GetMapping("/get")
    public ResponseEntity<Mono<User>> getUserById(@RequestParam String id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Mono<UserDto>> create(@RequestBody Mono<UserDto> userDtoMono) {
        return ResponseEntity.ok(userToDtoConverter.convert(userService.create(userDtoMono)));
    }*/
}
