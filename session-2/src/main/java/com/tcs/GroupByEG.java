package com.tcs;

import java.util.Map;
import reactor.core.publisher.Flux;

public class GroupByEG {


    public static void main(String[] args) throws InterruptedException {
        String line = "hello i am what i am";
        Map<String, Integer> map = new java.util.HashMap<>();
        Flux.fromArray(line.split(" "))
                .map(s ->{
                    map.put(s,map.getOrDefault(s,0)+1);
                    return map;
                })
           .subscribe(System.out::println);
        Thread.sleep(5000);
    }
}
