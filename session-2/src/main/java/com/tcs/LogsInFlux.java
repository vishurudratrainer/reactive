package com.tcs;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class LogsInFlux {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> flux = Flux.just(1,2,3);
        AtomicInteger count = new AtomicInteger(2);
        flux
                .map(integer -> integer/ count.decrementAndGet())
                .doOnError(throwable -> log.error(throwable.getMessage()))
                .onErrorResume(throwable -> Flux.just(0))
                .subscribe(System.out::println);
        Thread.sleep(4000);
    }
}
