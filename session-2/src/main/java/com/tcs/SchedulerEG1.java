package com.tcs;

import reactor.core.publisher.Flux;

public class SchedulerEG1 {

    public static void main(String[] args) throws InterruptedException {

        Flux<Integer> flux = Flux.just(1,2,3);
        flux.log().subscribe(System.out::println);
        Thread.sleep(3000);
    }
}
