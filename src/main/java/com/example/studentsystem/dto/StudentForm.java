package com.example.studentsystem.dto;


import com.example.studentsystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class StudentForm {
    private int id;
    private String name;
    private String address;

    public Student toEntity() {
        return new Student(id, name, address);
    }

}
