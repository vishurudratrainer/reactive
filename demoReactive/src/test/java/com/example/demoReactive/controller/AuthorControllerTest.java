package com.example.demoReactive.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static reactor.core.publisher.Mono.when;

import com.example.demoReactive.entity.Author;
import com.example.demoReactive.repository.AuthorRepo;
import com.example.demoReactive.service.AuthorService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = {AuthorController.class})
@Import(AuthorService.class)
class AuthorControllerTest {

    @MockBean
    AuthorRepo authorRepo;

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testAddAll(){

        List<Author> authorList = new ArrayList<>();
        Author author1 = new Author();
        author1.setName("auth11");
        Author author2 = new Author();
        author2.setName("auth12");
        authorList.add(author1);
        authorList.add(author2);
        Flux<Author> authorFlux = Flux.fromIterable(authorList);


        //equality wont work on flux objects, use Flux.class
        Mockito.when(authorRepo.saveAll(any(Flux.class))).thenReturn(authorFlux);

        webTestClient.post()
                .uri("/addAuthors")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(authorList))
                .exchange()
                .expectStatus()
                .isOk();


        Mockito.verify(authorRepo,Mockito.times(1)).saveAll(Mockito.any(Flux.class));
        Mockito.verify(authorRepo,Mockito.times(0)).findAll();

    }

    @Test
    void testGetAll(){
        List<Author> authorList = new ArrayList<>();
        Author author1 = new Author();
        author1.setName("auth11");
        Author author2 = new Author();
        author2.setName("auth12");
        authorList.add(author1);
        authorList.add(author2);
        Flux<Author> authorFlux = Flux.fromIterable(authorList);


        //equality wont work on flux objects, use Flux.class
        Mockito.when(authorRepo.findAll()).thenReturn(authorFlux);

        webTestClient.get()
                .uri("/getAll")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Author.class)
                .value(authors -> assertEquals(2,authors.size()))
                .value(authors -> assertTrue(authors.get(0).getName().contains("auth")))
                .value(authors -> assertTrue(authors.get(1).getName().contains("auth")));

    }

    @Test
    void testGetById(){
        Author author1 = new Author();
        author1.setName("auth11");
        UUID uuid = UUID.randomUUID();
        author1.setId(uuid);
        Mono<Author> authorMono = Mono.just(author1);

        Mockito.when(authorRepo.findById(any(UUID.class))).thenReturn(authorMono);



        webTestClient.get()
                .uri("/getbyid?uuid="+uuid.toString())
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Author.class)
                .value(author -> assertEquals(uuid,author.getId()));
    }
}