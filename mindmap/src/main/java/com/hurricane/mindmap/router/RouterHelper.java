package com.hurricane.mindmap.router;

import org.springframework.web.reactive.function.server.RequestPredicate;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

public interface RouterHelper {

    static RequestPredicate acceptJson() {
        return accept(APPLICATION_JSON);
    }

    static RequestPredicate cTypeJson() {
        return contentType(APPLICATION_JSON);
    }
}
