package com.tcs;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SchedulersEG {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> flux = Flux.just(1,2,3);
//        flux.log().subscribeOn(Schedulers.single()).subscribe(System.out::println);
//        flux.log().subscribeOn(Schedulers.parallel()).subscribe(System.out::println); //runs it parallel  used for non blocking executions
        flux.log().subscribeOn(Schedulers.boundedElastic()).subscribe(System.out::println);
        Thread.sleep(3000);
    }
}
