package com.example.errorhandlingflux.handler;


import com.example.errorhandlingflux.exception.UserNameRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class RequestHandler4 {

    public Mono<ServerResponse> handleRequest4(ServerRequest request) {
        return ServerResponse.ok()
                .body(sayHello(request)
                        .onErrorResume(e ->
                                Mono.error(new UserNameRequiredException(
                                        HttpStatus.BAD_REQUEST, "please provide a username", e))), String.class);
    }

    private Mono<String> sayHello(ServerRequest request) {
        try {
            return Mono.just("Hello, " + request.queryParam("username").get());
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

}