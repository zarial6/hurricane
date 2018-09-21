package com.hurricane.mindmap.router;

import com.hurricane.mindmap.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * @author Oleg Zhymolokhov (oleg.zhimolokhov@dataart.com)
 */
@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> route(UserHandler userHandler) {
        return RouterFunctions.route(GET("/users/{id}").and(accept(APPLICATION_JSON)), userHandler::getById)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)), userHandler::all)
                .andRoute(POST("/users").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), userHandler::create)
                .andRoute(PUT("/users").and(accept(APPLICATION_JSON)).and(contentType(APPLICATION_JSON)), userHandler::update)
                .andRoute(DELETE("/users/{id}"), userHandler::delete);
    }
}
