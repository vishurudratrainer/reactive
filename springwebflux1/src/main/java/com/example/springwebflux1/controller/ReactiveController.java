package com.example.springwebflux1.controller;

import com.example.springwebflux1.service.ReactiveService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class ReactiveController {

    @Autowired
    private ReactiveService reactiveService;

    @GetMapping(value = "/reactivegetall",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<String> getAll(){
        return reactiveService.getAll();
    }
}
