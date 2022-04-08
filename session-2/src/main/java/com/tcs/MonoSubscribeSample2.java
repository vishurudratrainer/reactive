package com.tcs;

import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Mono;

public class MonoSubscribeSample2 {

    public static void main(String[] args) {
        String[] arr = new String[1];
        Mono<String> helloWorld = Mono.just("Hello World");
        helloWorld.subscribe(s -> arr[0]=s);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arr[0]);
    }
}
