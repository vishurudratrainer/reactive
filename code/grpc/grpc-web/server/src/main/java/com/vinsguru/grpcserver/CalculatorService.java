package com.vinsguru.grpcserver;

import com.vinsguru.calculator.Input;
import com.vinsguru.calculator.Output;
import com.vinsguru.calculator.ReactorCalculatorServiceGrpc;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;


public class CalculatorService extends ReactorCalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public Mono<Output> findSquare(Mono<Input> request) {
        System.out.println("received square request");
        return request.map(Input::getNumber)
                .map(i -> Output.newBuilder().setResult(i * i).build());
    }

    @Override
    public Flux<Output> findFactors(Mono<Input> request) {
        System.out.println("received factor request");
        return request.map(Input::getNumber)
                .filter(i -> i > 0)
                .flatMapMany(input -> Flux.range(2, input / 2)
                        .filter(f -> input % f == 0))
                .delayElements(Duration.ofMillis(200))
                .doFinally(System.out::println)
                .map(o -> Output.newBuilder().setResult(o).build());
    }

    @Override
    public Mono<Output> findSum(Flux<Input> request) {
        return request
                .map(Input::getNumber)
                .reduce(Integer::sum)
                .map(i -> Output.newBuilder().setResult(i).build());
    }

}
