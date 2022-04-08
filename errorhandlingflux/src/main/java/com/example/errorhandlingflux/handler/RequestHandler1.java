package com.example.errorhandlingflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RequestHandler1 {

    public Mono<ServerResponse> handleRequest1(ServerRequest request) {
        return sayHello(request).onErrorReturn("Error "+" Exception ")
                .flatMap(s -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .bodyValue(s));
    }

    private Mono<String> sayHello(ServerRequest request) {
        try {
            return Mono.just("Hello, " + request.queryParam("username")
                    .get());
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

}