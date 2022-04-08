package com.tcs;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class ConcatFlux {

    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        Flux<Integer> flux2 = Flux.just(4, 5, 6).delayElements(Duration.ofMillis(5000));

//        Flux.concat(flux1,flux2)
//                .subscribe(System.out::println);
//        Flux.merge(flux1,flux2)
//                .subscribe(System.out::println);
//        flux1.concatWith(flux2)
//                .subscribe(System.out::println);
        flux1.zipWith(flux2, (dataFromFlux1, dataFromFlux2) -> dataFromFlux1 + dataFromFlux2)
                .subscribe(System.out::println);
        Thread.sleep(35000);
    }
}
