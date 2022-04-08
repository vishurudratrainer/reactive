package com.tcs;

import reactor.core.publisher.Flux;

public class FluxExtended3 {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> integerFlux = Flux.range(1,5);
        integerFlux.log().subscribe(
                successVal->System.out.println(successVal),
                error->System.out.println(error),
                ()-> System.out.println("on Completed")
        );
        Thread.sleep(5000);
    }
}
