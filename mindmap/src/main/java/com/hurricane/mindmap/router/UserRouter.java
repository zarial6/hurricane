package com.hurricane.mindmap.router;

import com.hurricane.mindmap.handler.UserHandler;
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

/**
 * @author Oleg Zhymolokhov (oleg.zhimolokhov@dataart.com)
 */
@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> routeUsers(UserHandler userHandler) {
        return RouterFunctions.nest(
                RequestPredicates.path("/users"),
                RouterFunctions.route(GET("/{id}").and(acceptJson()), userHandler::getById)
                        .andRoute(method(GET).and(acceptJson()), userHandler::all)
                        .andRoute(method(POST).and(acceptJson()).and(cTypeJson()), userHandler::create)
                        .andRoute(method(PUT).and(acceptJson()).and(cTypeJson()), userHandler::update)
                        .andRoute(DELETE("/{id}"), userHandler::delete)
        );
    }
}
