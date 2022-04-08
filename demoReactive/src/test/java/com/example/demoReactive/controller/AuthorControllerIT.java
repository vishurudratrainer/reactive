package com.example.demoReactive.controller;

import com.example.demoReactive.entity.Author;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthorControllerIT {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testPost(){
        WebTestClient webTestClient = WebTestClient.bindToApplicationContext(applicationContext).configureClient().build();

        List<Author> authorList = new ArrayList<>();
        Author author1 = new Author();
        author1.setName("auth11");
        Author author2 = new Author();
        author2.setName("auth12");
        authorList.add(author1);
        authorList.add(author2);
        Flux<Author> authorFlux = Flux.fromIterable(authorList);

        webTestClient.post()
                .uri("/addAuthors")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(authorList))
                .exchange()
                .expectStatus()
                .isOk();
    }
}
