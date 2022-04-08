package com.tcs;

import reactor.core.publisher.Mono;

public class MonoExtended2 {

    public static void main(String[] args) throws InterruptedException {
        Mono<String> stringMono = Mono.error(new Exception("ERROR"));
        stringMono.log().subscribe(
                successVal->System.out.println(successVal),
                error->System.out.println(error),
                ()-> System.out.println("on Completed")
        );
        Thread.sleep(5000);
    }
}
