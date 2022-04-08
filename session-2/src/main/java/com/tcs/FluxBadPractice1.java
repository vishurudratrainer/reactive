package com.tcs;

import reactor.core.publisher.Flux;

public class FluxBadPractice1 {

    public static void main(String[] args) {
        System.out.println(Flux.just(1,2,3).blockFirst());
    }
}
