package com.example.reactiveRelationship.repository;

import com.example.reactiveRelationship.entity.Author;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends ReactiveCrudRepository<Author, UUID> {

}
