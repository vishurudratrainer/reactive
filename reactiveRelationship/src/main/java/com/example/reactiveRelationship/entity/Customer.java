package com.example.reactiveRelationship.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("customer")
public class Customer {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Long orderId;
}
