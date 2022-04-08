package com.example.reactiveRelationship.entity;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("book")
@Data
public class Book {

    @Id
    @Column
    private UUID id;

    @Column
    private String title;

    @Column
    private UUID author;

    @Column
    private Instant dateOfPartition;

    @Transient
    private Author retrievedAuthor;
}
