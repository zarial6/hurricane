package com.hurricane.mindmap.controller;

/*@Controller
@RequestMapping("/user")*/
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
