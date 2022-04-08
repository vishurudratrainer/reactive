package com.example.springwebflux1.controller;

import com.example.springwebflux1.service.NormalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormalController {

    @Autowired
    private NormalService normalService;

    @GetMapping("/normalgetall")
    public List<String> getAll(){
        return normalService.getAll();
    }
}
