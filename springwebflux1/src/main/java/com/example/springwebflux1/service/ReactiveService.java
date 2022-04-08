package com.example.springwebflux1.service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Service
public class ReactiveService {

    public Flux<String> getAll(){

        return Flux.just("1","2","3","4","5").log().subscribeOn(Schedulers.parallel()).delayElements(Duration.of(1,ChronoUnit.SECONDS));
    }

}
