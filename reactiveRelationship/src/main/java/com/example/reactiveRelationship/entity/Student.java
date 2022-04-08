package com.example.reactiveRelationship.entity;

import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("student")
@Data
public class Student {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private Long departmentId;
}
