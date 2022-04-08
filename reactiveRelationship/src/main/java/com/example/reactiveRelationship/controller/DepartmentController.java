package com.example.reactiveRelationship.controller;

import com.example.reactiveRelationship.entity.Department;
import com.example.reactiveRelationship.repository.DepartmentRepo;
import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @PostMapping("/addDepartments")
    public Flux<Department> addDepartments(@RequestBody Flux<Department> departmentFlux) {
        return departmentRepo.saveAll(departmentFlux);
    }

    @GetMapping("/getDepartments")
    public Flux<Department> getDepartments() {
        return departmentRepo.findAll();

    }

    @GetMapping("/getDepartmentsFlux")
    public Mono<Map<Long, Collection<Department>>> getDepartmentsFlux() {
        Flux<Department> departmentFlux = departmentRepo.findAll();
        Mono<Map<Long, Collection<Department>>> departmentMono = departmentFlux.collectMultimap(department -> department.getId(), department -> department);
        return departmentMono;
    }

    @GetMapping("/getDepartmentsFlux2")
    public Flux<Department> getDepartmentsFlux2() {
        Flux<Department> departmentFlux = departmentRepo.findAll();

       return departmentFlux.groupBy(department -> department.getId())
                .flatMap(g -> g.reduce((a, b) -> {
                    a.getStudents().addAll(b.getStudents());
                    return a;
                }));
    }
}
