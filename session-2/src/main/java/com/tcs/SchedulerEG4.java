package com.tcs;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SchedulerEG4 {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> flux = Flux.just(1,2,3);
        flux.log()
                .parallel(3)
                .runOn(Schedulers.parallel())
                .map(integer -> integer*10)
                .map(integer -> integer*10)
                .subscribe(s->System.out.println(s+": " + Thread.currentThread().getName()));
        Thread.sleep(3000);
    }
}
