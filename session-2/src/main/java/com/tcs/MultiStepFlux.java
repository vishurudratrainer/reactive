package com.tcs;

import reactor.core.publisher.Flux;

public class MultiStepFlux {

    public static void main(String[] args) throws InterruptedException {
        Flux.range(1,5)
                .map(UserUtil::getUserById)
                .map(UserUtil::capitalizeUsername)
                .collectList()
                .subscribe(System.out::println);
        Thread.sleep(5000);
    }
}
