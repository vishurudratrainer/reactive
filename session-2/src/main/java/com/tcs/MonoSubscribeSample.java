package com.tcs;

import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Mono;

public class MonoSubscribeSample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Mono<String> helloWorld = Mono.just("Hello World");
        helloWorld.subscribe(list::add);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }
}
