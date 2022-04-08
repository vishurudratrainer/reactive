package com.example.reactiveRelationship.repository;

import com.example.reactiveRelationship.entity.Book;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepo extends R2dbcRepository<Book, UUID> {

    @Query("select book.*, author.id as authorId, author.name as authorName from Book book join Author author on author.id = book.author ")
    public Flux<Book> findAll();
}
