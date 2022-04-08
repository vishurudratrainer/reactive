package com.example.springwebfluxmongo.repository;

import com.example.springwebfluxmongo.entity.Emp;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends ReactiveMongoRepository<Emp,Long> {

}
