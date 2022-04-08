package com.example.reactiveRelationship.controller;

import com.example.reactiveRelationship.entity.Customer;
import com.example.reactiveRelationship.entity.Order;
import com.example.reactiveRelationship.repository.CustomerRepo;
import com.example.reactiveRelationship.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @PostMapping(value = "/addOrders",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Order> addAll(@RequestBody Flux<Order> orderFlux) {
        return orderRepo.saveAll(orderFlux);
    }

    @GetMapping(value = "/getOrders",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Order> getAll(){
        return orderRepo.findAll();
    }
}
