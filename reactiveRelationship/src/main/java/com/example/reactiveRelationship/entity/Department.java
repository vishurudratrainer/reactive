package com.example.reactiveRelationship.entity;

import java.util.List;
import java.util.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("department")
@Data
public class Department {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Transient
    private List<Student> students;
}
