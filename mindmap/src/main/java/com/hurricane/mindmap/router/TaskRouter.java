package com.hurricane.mindmap.router;

import com.hurricane.mindmap.handler.TaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class TaskRouter {

    @Bean
    public RouterFunction<ServerResponse> route(TaskHandler taskHandler) {
        return RouterFunctions.route(GET("/tasks{id}").and(accept(APPLICATION_JSON)), taskHandler::getById)
                .andRoute(GET("/tasks").and(accept(APPLICATION_JSON)), taskHandler::all)
                .andRoute(POST("tasks").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), taskHandler::create)
                .andRoute(PUT("/tasks").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), taskHandler::update)
                .andRoute(DELETE("/tasks/{id}"), taskHandler::delete);
    }
}
