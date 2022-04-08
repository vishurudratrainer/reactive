package com.example.demoJdbcReactive.repository;

import com.example.demoJdbcReactive.entity.Emp;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmpRepository extends ReactiveCrudRepository<Emp,Long> {

    @Query("select * from emp where emp_age = :age")
    Flux<Emp> getEmpByAge(@Param("age") Integer age);
}
