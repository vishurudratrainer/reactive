package com.example.reactiveRelationship.controller;

import com.example.reactiveRelationship.entity.Book;
import com.example.reactiveRelationship.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @PostMapping(value = "/addBooks",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Book> addAll(@RequestBody Flux<Book> books) {
        return bookRepo.saveAll(books);
    }

    @GetMapping("/getAll")
    public Flux<Book> getAll(){
        return bookRepo.findAll();
    }
}
