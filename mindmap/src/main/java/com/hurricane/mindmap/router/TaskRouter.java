package com.hurricane.mindmap.router;

import com.hurricane.mindmap.handler.TaskHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.hurricane.mindmap.router.RouterHelper.acceptJson;
import static com.hurricane.mindmap.router.RouterHelper.cTypeJson;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class TaskRouter {

    @Bean
    public RouterFunction<ServerResponse> routeTasks(TaskHandler taskHandler) {
        return RouterFunctions.nest(
                RequestPredicates.path("/tasks"),
                RouterFunctions.route(GET("/{id}").and(acceptJson()), taskHandler::getById)
                        .andRoute(method(GET).and(acceptJson()), taskHandler::all)
                        .andRoute(method(POST).and(acceptJson()).and(cTypeJson()), taskHandler::create)
                        .andRoute(method(PUT).and(acceptJson()).and(cTypeJson()), taskHandler::update)
                        .andRoute(DELETE("/{id}"), taskHandler::delete)
        );
    }
}
