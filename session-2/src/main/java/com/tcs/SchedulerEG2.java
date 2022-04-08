package com.tcs;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SchedulerEG2 {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> flux = Flux.just(1,2,3);
        System.out.println( "Before Flux : " + Thread.currentThread().getName());
        flux.log().subscribeOn(Schedulers.single()).subscribe(s-> {
            System.out.println(s + " : " + Thread.currentThread().getName());
        });
        Thread.sleep(3000);
    }
}
