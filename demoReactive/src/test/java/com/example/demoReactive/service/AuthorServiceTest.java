package com.example.demoReactive.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.demoReactive.entity.Author;
import com.example.demoReactive.repository.AuthorRepo;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
class AuthorServiceTest {

    @Mock
    AuthorRepo authorRepo;

    @InjectMocks
    AuthorService authorService;

    @Test
    void testFindAll(){
        List<Author> authorList = new ArrayList<>();
        Author author1 = new Author();
        author1.setName("auth11");
        Author author2 = new Author();
        author2.setName("auth12");
        authorList.add(author1);
        authorList.add(author2);
        Flux<Author> authorFlux = Flux.fromIterable(authorList);

        Mockito.when(authorRepo.findAll()).thenReturn(authorFlux);

        Flux<Author> retrievedObject = authorService.getAll();

        StepVerifier.create(retrievedObject)
                .expectNextMatches(author -> author.getName().equals("auth11"))
                .expectNextMatches(author -> author.getName().equals("auth12"))
                .verifyComplete();

    }

}