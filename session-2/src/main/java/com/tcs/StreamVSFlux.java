package com.tcs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class StreamVSFlux {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1,2,3); //flux are immutable
        flux.map(integer -> integer*integer).subscribe(System.out::println);
        flux.map(integer -> integer*integer).subscribe(System.out::println);

        List<Integer> list = List.of(1,2,3);
        Stream<Integer> stream = list.stream(); //can be used only once
        stream.map(integer -> integer*integer).forEach(System.out::println);
        stream.map(integer -> integer*integer).forEach(System.out::println);
    }
}
