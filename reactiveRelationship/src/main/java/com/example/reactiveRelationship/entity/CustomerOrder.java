package com.example.reactiveRelationship.entity;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("customer_order")
public class CustomerOrder {

    @Column
    private Long orderId;

    @Column
    private Long customerId;
}
