package com.tcs;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoCreationSample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Mono<String> helloWorld = Mono.just("Hello World");
        Mono<String> emptyMono = Mono.empty();
        Mono<String> fromCallable = Mono.fromCallable(()->"Hello World from Thread");
        Mono<Integer> fromFlux = Mono.from(Flux.range(1,5));
        FutureEG futureEG = new FutureEG();
       Mono<String> fromCallableFuture = Mono.fromCallable(futureEG);
       fromCallableFuture.subscribe(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
