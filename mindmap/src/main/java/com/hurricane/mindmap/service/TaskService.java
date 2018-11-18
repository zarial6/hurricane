package com.hurricane.mindmap.service;


import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.model.Task;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface TaskService {

    Mono<Task> update(Mono<TaskDto> dtoMono);

    Mono<Void> delete(String id);

    Mono<Task> getById(String id);

    Flux<Task> findAll();

    Mono<Task> create(Mono<TaskDto> dtoMono);
}
