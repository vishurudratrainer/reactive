package com.tcs;

import reactor.core.publisher.Mono;

public class MonoBadPractice1 {

    public static void main(String[] args) {
       String s = Mono.just("usa").block(); //makes this synchronous
        System.out.println(s);
    }
}
