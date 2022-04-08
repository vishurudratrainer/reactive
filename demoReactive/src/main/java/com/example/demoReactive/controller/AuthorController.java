package com.example.demoReactive.controller;

import com.example.demoReactive.entity.Author;
import com.example.demoReactive.repository.AuthorRepo;

import com.example.demoReactive.service.AuthorService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(value = "/addAuthors",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Author> addAll(@RequestBody Flux<Author> authors) {
        return authorService.addAll(authors);
    }

    @GetMapping(value = "/getAll",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Author> getAll() {
        return authorService.getAll();
    }

    @GetMapping(value = "/getbyid")
    public Mono<Author> getByID(@RequestParam UUID uuid) {
        return authorService.getById(uuid);
    }
}
