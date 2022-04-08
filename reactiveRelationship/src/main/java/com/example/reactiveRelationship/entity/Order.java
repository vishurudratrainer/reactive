package com.example.reactiveRelationship.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
public class Order {

    @Id
    @Column
    private Long id;

    @Column
    private String description;

    @Column
    private Integer amount;

    @Column
    private Long customerId;
}
