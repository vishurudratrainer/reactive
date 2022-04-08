package com.tcs;

import reactor.core.publisher.Mono;

public class MonoExtended {

    public static void main(String[] args) {
        Mono<String> stringMono = Mono.just("hello");
        stringMono.subscribe(
                successVal->System.out.println(successVal),
                error->System.out.println(error),
                ()-> System.out.println("on Completed")
                );
    }
}
