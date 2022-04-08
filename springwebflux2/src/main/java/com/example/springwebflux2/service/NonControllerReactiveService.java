package com.example.springwebflux2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class NonControllerReactiveService {
    public Mono<ServerResponse> sendResponce(ServerRequest serverRequest){
        return ServerResponse.ok().body(BodyInserters.fromValue("Hello "));
    }
}
