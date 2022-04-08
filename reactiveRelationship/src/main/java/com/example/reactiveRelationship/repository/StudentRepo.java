package com.example.reactiveRelationship.repository;

import com.example.reactiveRelationship.entity.Student;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends R2dbcRepository<Student,Long> {

}
