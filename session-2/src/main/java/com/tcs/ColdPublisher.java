package com.tcs;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import reactor.core.publisher.Flux;

public class ColdPublisher {

    public static void main(String[] args) throws InterruptedException {
        //a publisher is said to be cold publisher even if the subscriber which starts late gets all the values

        Flux<Long> flux = Flux.interval(Duration.of(1, ChronoUnit.SECONDS));
        flux.subscribe(s->System.out.println("1st SUB "+ s));
//        Thread.sleep(3000);
        flux.subscribe(s->System.out.println("2nd SUB "+ s));
        Thread.sleep(5000);
    }
}
