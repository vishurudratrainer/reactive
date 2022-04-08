package com.example.reactiveRelationship.config;

import com.example.reactiveRelationship.entity.Author;
import com.example.reactiveRelationship.entity.Book;
import com.example.reactiveRelationship.entity.Department;
import com.example.reactiveRelationship.entity.Student;
import io.r2dbc.spi.Row;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
@Slf4j
public class DepartmentReadConverter implements Converter<Row, Department> {

    @Override
    public Department convert(Row source) {
       Department department = new Department();
       department.setId(source.get("id", Long.class));
       department.setName(source.get("name", String.class));
       List<Student> list = new ArrayList<>();
       Student student = new Student();
       student.setId(source.get("student_id", Long.class));
       student.setName(source.get("student_name", String.class));
       student.setAge(source.get("student_age", Integer.class));
       student.setDepartmentId(source.get("id", Long.class));
       list.add(student);
       department.setStudents(list);
       return department;
    }

}