package com.example.springwebfluxmongo.controller;

import com.example.springwebfluxmongo.entity.Emp;
import com.example.springwebfluxmongo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmpController {

    @Autowired
    private EmpRepository empRepository;

    @PostMapping(value = "/add",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<Emp> add(@RequestBody Emp emp){
        return empRepository.save(emp);
    }

    @GetMapping(value="/getAll",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Emp> getAll(){
        return empRepository.findAll();
    }
}
