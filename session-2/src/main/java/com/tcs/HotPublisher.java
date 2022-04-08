package com.tcs;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class HotPublisher {

    public static void main(String[] args) throws InterruptedException {
        //subscriber will get only those which have been emitted after it starts
        Flux<Long> flux = Flux.interval(Duration.of(1, ChronoUnit.SECONDS));
        ConnectableFlux<Long> connectableFlux = flux.publish();
        connectableFlux.subscribe(s-> System.out.println("1st "+ s));
        connectableFlux.connect();
        Thread.sleep(3000);
        connectableFlux.subscribe(s-> System.out.println("2nd "+ s));
        Thread.sleep(5000);
    }
}
