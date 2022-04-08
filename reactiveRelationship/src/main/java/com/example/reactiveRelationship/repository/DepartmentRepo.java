package com.example.reactiveRelationship.repository;

import com.example.reactiveRelationship.entity.Book;
import com.example.reactiveRelationship.entity.Department;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DepartmentRepo extends R2dbcRepository<Department,Long> {

    @Query("select department.*, student.id as student_id, student.name as student_name, student.age as student_age from Department department join Student student on department.id = student.department_id")
    public Flux<Department> findAll();
}
