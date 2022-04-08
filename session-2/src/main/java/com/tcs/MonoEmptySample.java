package com.tcs;

import reactor.core.publisher.Mono;

public class MonoEmptySample {

    public static void main(String[] args) {
        //mono which not emit any element
        Mono<String> emptyMono = Mono.empty();
        emptyMono.subscribe(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
