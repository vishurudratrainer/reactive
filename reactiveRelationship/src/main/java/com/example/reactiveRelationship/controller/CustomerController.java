package com.example.reactiveRelationship.controller;

import com.example.reactiveRelationship.entity.Book;
import com.example.reactiveRelationship.entity.Customer;
import com.example.reactiveRelationship.repository.BookRepo;
import com.example.reactiveRelationship.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CustomerController {


    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping(value = "/addCustomers",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Customer> addAll(@RequestBody Flux<Customer> customerFlux) {
        return customerRepo.saveAll(customerFlux);
    }

    @GetMapping(value = "/getCustomers",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Customer> getAll(){
        return customerRepo.findAll();
    }
}
