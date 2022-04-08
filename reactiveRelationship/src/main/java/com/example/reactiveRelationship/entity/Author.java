package com.example.reactiveRelationship.entity;

import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("author")
@Data
public class Author {

    @Id
    @Column
    private UUID id;

    @Column
    private String name;
}
