package com.example.errorhandlingflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RequestHandler2 {

    public Mono<ServerResponse> handleRequest2(ServerRequest request) {
        return
                sayHello(request)
                        .flatMap(s -> ServerResponse.ok()
                                .contentType(MediaType.TEXT_PLAIN)
                                .bodyValue(s))
                        .onErrorResume(e -> sayHelloFallback()
                                .flatMap(s -> ServerResponse.ok()
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(s)));
    }

    private Mono<String> sayHello(ServerRequest request) {
        try {
            return Mono.just("Hello, " + request.queryParam("username")
                    .get());
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    private Mono<String> sayHelloFallback() {
        return Mono.just("Error in Param ");
    }

}