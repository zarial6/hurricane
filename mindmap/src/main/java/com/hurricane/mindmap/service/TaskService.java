package com.hurricane.mindmap.service;


import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.model.Task;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface TaskService {

    Flux<Task> findAll();

    Mono<Task> getById(String id);

    Mono<Task> create(Mono<TaskDto> dtoMono);

    Mono<Task> update(Mono<TaskDto> dtoMono);

    Mono<Void> delete(String id);
}
