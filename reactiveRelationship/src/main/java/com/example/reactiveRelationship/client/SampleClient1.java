package com.example.reactiveRelationship.client;

import com.example.reactiveRelationship.entity.Book;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Flux;

public class SampleClient1 {

    public static void main(String[] args) throws InterruptedException {
        WebClient webClient = WebClient.create();

       ResponseSpec responseSpec = webClient.get()
                .uri("http://localhost:8080/getAll")
                .retrieve();

       Flux<Book> bookFlux = responseSpec.bodyToFlux(Book.class);
       bookFlux.subscribe(System.out::println);

       Thread.sleep(3000);
    }
}
