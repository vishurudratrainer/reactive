package com.example.demoReactive.service;

import com.example.demoReactive.entity.Author;
import com.example.demoReactive.repository.AuthorRepo;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public Flux<Author> addAll(@RequestBody Flux<Author> authors) {
        return authorRepo.saveAll(authors);
    }

    public Flux<Author> getAll() {
        return authorRepo.findAll();
    }

    public Mono<Author> getById(UUID uuid) {
        return authorRepo.findById(uuid);
    }
}
