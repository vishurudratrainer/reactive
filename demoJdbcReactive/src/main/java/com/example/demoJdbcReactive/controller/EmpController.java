package com.example.demoJdbcReactive.controller;

import com.example.demoJdbcReactive.entity.Emp;
import com.example.demoJdbcReactive.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmpController {

    @Autowired
    private EmpRepository empRepository;

    @PostMapping(value = "/add",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<Emp> addEmp(@RequestBody Emp emp) {
        return empRepository.save(emp);
    }

    @PostMapping(value = "/addAll",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Emp> addAll(@RequestBody Flux<Emp> emps) {
        return empRepository.saveAll(emps);
    }

    @GetMapping(value = "/get",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<Emp> getEmp(@RequestParam Long empId) {
        return empRepository.findById(empId);
    }

    @GetMapping(value = "/getAll",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<Emp> getAll() {
        return empRepository.findAll();
    }

    @PutMapping(value = "/update",produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Mono<Emp> updateEmp(@RequestBody Emp emp) {
        return empRepository.save(emp);
    }

    @GetMapping("/getbyage")
    public Flux<Emp> getByAge(@RequestParam Integer age){
        return empRepository.getEmpByAge(age);
    }
}
