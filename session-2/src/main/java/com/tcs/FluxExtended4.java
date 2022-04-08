package com.tcs;

import reactor.core.publisher.Flux;

public class FluxExtended4 {

    public static void main(String[] args) throws InterruptedException {
        Flux<String> integerFlux = Flux.just("1","hello","2");
        integerFlux.map(s -> Integer.parseInt(s)).log().subscribe(
                successVal->System.out.println(successVal),
                error->System.out.println(error + "Error here"),
                ()-> System.out.println("on Completed")
        );

        Thread.sleep(5000);
    }
}
