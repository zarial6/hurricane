package com.hurricane.mindmap.handler;

import com.hurricane.mindmap.converter.TaskToDtoConverter;
import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.model.Task;
import com.hurricane.mindmap.service.TaskService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static org.springframework.http.MediaType.APPLICATION_JSON;


import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.*;
import static org.springframework.web.util.UriComponentsBuilder.fromPath;

@Component
public class TaskHandler {

    private final TaskService taskService;
    private final TaskToDtoConverter taskToDtoConverter;

    public TaskHandler(TaskService taskService, TaskToDtoConverter movieToDtoConverter) {
        this.taskService = taskService;
        this.taskToDtoConverter = movieToDtoConverter;
    }


    public Mono<ServerResponse> getById(ServerRequest request) {
        return request.queryParam("id")
                .map(taskService::getById)
                .map(taskMono -> taskMono.flatMap(task -> ok().contentType(APPLICATION_JSON)
                        .body(Mono.justOrEmpty(taskToDtoConverter.convert(task)), TaskDto.class)
                        .switchIfEmpty(notFound().build()))
                ).orElse(badRequest().build());
    }


    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<TaskDto> taskDtoMono = request.bodyToMono(TaskDto.class);
        Mono<Task> taskMono = taskService.create(taskDtoMono);
        return taskMono.flatMap(task -> created(fromPath("task/".concat(task.getId())).build().toUri())
                .contentType(APPLICATION_JSON)
                .body(Mono.justOrEmpty(taskToDtoConverter.convert(task)), TaskDto.class)
                .switchIfEmpty(notFound().build()));
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        Mono<TaskDto> taskDtoMono = request.bodyToMono(TaskDto.class);
        return taskService.update(taskDtoMono)
                .flatMap(createdTask -> created(fromPath("task/".concat(createdTask.getId())).build().toUri())
                        .contentType(APPLICATION_JSON)
                        .body(Mono.justOrEmpty(taskToDtoConverter.convert(createdTask)), TaskDto.class)
                ).switchIfEmpty(notFound().build());
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return noContent()
                .build(taskService.delete(request.pathVariable("id")))
                .switchIfEmpty(notFound().build());
    }


    public Mono<ServerResponse> all(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(fromPublisher(taskService.findAll().map(taskToDtoConverter::convert), TaskDto.class))
                .switchIfEmpty(notFound().build());
    }
}
