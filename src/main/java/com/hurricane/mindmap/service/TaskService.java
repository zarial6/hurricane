package com.hurricane.mindmap.service;


import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.dto.UserDto;
import com.hurricane.mindmap.model.Task;
import com.hurricane.mindmap.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.Set;

public interface TaskService {

    Set<Task> getMovie();

    Mono<Task> findById(String id);

    Mono<Task> saveMovie(Task task);


    Mono<Task> getById(String id);

    Flux<Task> findAll();

    Mono<Task> create(Mono<TaskDto> dtoMono);
}
