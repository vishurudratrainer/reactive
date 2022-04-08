package com.vishwa.webfluxsse.controller;

import com.vishwa.webfluxsse.producer.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StreamController {

    @Autowired
    private Flux<Todo> flux;

    @GetMapping(value = "Todo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Todo> getToDo(){
        return flux;
    }

}
