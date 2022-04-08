package com.example.springwebflux1.controller;

import com.example.springwebflux1.service.AlternateReactiveService;
import com.example.springwebflux1.service.ReactiveService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AlternateReactiveController {

    @Autowired
    private AlternateReactiveService alternateReactiveService;

    @GetMapping("/alternatereactivegetall")
    public List<Mono<String>> getAll(){
        return alternateReactiveService.getAll();
    }
}
