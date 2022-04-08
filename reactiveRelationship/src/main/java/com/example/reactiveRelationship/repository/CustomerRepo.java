package com.example.reactiveRelationship.repository;

import com.example.reactiveRelationship.entity.Customer;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends R2dbcRepository<Customer,Long> {

}
