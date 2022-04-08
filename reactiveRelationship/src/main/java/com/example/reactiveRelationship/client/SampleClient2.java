package com.example.reactiveRelationship.client;

import com.example.reactiveRelationship.entity.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SampleClient2 {

    public static void main(String[] args) throws InterruptedException {
        WebClient webClient = WebClient.create();

        ResponseSpec responseSpec = webClient.get()
                .uri("https://jsonplaceholder.typicode.com/todos")
                .retrieve();

        Mono<ResponseEntity<String>> bookFlux = responseSpec.toEntity(String.class);
        bookFlux.subscribe(System.out::println);

        Thread.sleep(3000);
    }
}
