package com.example.studentsystem.service;

import com.example.studentsystem.entity.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();

}
