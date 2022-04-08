package com.example.reactiveRelationship.controller;

import com.example.reactiveRelationship.entity.Author;
import com.example.reactiveRelationship.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepo authorRepo;

    @PostMapping(value = "/addAuthors",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Author> addAll(@RequestBody Flux<Author> authors) {
        return authorRepo.saveAll(authors);
    }
}
