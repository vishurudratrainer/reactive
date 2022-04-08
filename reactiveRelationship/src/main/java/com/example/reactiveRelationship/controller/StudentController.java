package com.example.reactiveRelationship.controller;

import com.example.reactiveRelationship.entity.Student;
import com.example.reactiveRelationship.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StudentController{

    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/addStudents")
    public Flux<Student> addStudents(@RequestBody Flux<Student> studentFlux){
        return studentRepo.saveAll(studentFlux);
    }

    @GetMapping("/getStudents")
    public Flux<Student> getStudents(){
        return studentRepo.findAll();
    }
}
