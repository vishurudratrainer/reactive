package com.example.reactiveRelationship.repository;

import com.example.reactiveRelationship.entity.Customer;
import com.example.reactiveRelationship.entity.Order;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends R2dbcRepository<Order,Long> {

}
