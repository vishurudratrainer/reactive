package com.vishwa.webfluxsse.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Sinks;

@Service
public class TodoPublisher {

    @Autowired
    private WebClient webClient;

    @Autowired
    private Sinks.Many<Todo> sink;
  int id = 1;
    @Scheduled(fixedRate = 2000)
    public void publish(){
        this.webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/"+id++)

                .build())
                .retrieve()
                .bodyToMono(Todo.class)
                .log()
                .subscribe(this.sink::tryEmitNext);
    }

}
