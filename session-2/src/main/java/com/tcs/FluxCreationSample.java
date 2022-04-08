package com.tcs;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Flux;

public class FluxCreationSample {


    public static void main(String[] args) {
        Flux<Integer> s1 = Flux.just(1,2,3,4);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Flux<Integer> fromList = Flux.fromIterable(list); //creating flux from a list
        Flux<Integer> fromStream = Flux.fromStream(list.stream());
        Flux<Integer> fromRange = Flux.range(1,5);
        Flux<Integer> fromOtherFlux = Flux.from(s1);
        Flux<Long> fromInterval = Flux.interval(Duration.of(1000, ChronoUnit.MILLIS));

    }
}
