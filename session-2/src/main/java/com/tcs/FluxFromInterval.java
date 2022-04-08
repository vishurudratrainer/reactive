package com.tcs;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import reactor.core.publisher.Flux;

public class FluxFromInterval {

    public static void main(String[] args) {
        Flux<Long> fromInterval = Flux.interval(Duration.of(2000, ChronoUnit.MILLIS));
        fromInterval.subscribe(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
