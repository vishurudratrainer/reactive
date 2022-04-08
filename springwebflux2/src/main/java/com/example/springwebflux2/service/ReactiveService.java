package com.example.springwebflux2.service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class ReactiveService {

    public Mono<ServerResponse> getAll(ServerRequest serverRequest){
        return ServerResponse.ok().body(BodyInserters.fromPublisher(Flux.just("1","2","3","4","5").log().subscribeOn(Schedulers.parallel()).delayElements(Duration.of(1,ChronoUnit.SECONDS)),String.class));
    }

}
