package com.hurricane.mindmap.handler;


import com.hurricane.mindmap.converter.TaskToDtoConverter;
import com.hurricane.mindmap.dto.TaskDto;
import com.hurricane.mindmap.model.Task;
import com.hurricane.mindmap.service.TaskService;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;



import static org.springframework.http.MediaType.APPLICATION_JSON;


import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.*;


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
                .map(movie -> ok().contentType(APPLICATION_JSON)
                        .body(fromPublisher(movie.flatMap(taskToDtoConverter::convert), TaskDto.class))
                        .switchIfEmpty(notFound().build())
                ).orElse(badRequest().build());
    }

   public Mono<ServerResponse> findAll(ServerRequest request)
   {
       return ok().contentType(APPLICATION_JSON)
               .body(fromPublisher(taskService.findAll(), Task.class));

   }

   public Mono<ServerResponse> create(ServerRequest request)
   {
        Mono<TaskDto> movieDtoMono = request.bodyToMono(TaskDto.class);
        Mono<Task> movieMono = taskService.create(movieDtoMono);
        return movieMono.flatMap(movie -> created(UriComponentsBuilder.fromPath("/movie".concat(movie.getId())).build().toUri())
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(movieMono.flatMap(taskToDtoConverter::convert), TaskDto.class))
                .switchIfEmpty(notFound().build()));


   }


}
