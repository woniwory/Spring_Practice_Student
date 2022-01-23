package com.example.studentsystem.controller;

import com.example.studentsystem.dto.StudentForm;
import com.example.studentsystem.entity.Student;
import com.example.studentsystem.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j

public class StudentController {
    @Autowired
    private StudentRepository studentRepository;


     // Get
    @GetMapping("/students")
    public List<Student> index() {
        return studentRepository.findAll();

    }

    @GetMapping("/students/{id}")
    public Student index(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }


    //Post

    @PostMapping("/create")
    public Student create(@RequestBody StudentForm dto){
        Student student = dto.toEntity();
        return studentRepository.save(student);
    }

    @PatchMapping("/api/students/{id}")
    public ResponseEntity<Student> update(@PathVariable int id, @RequestBody StudentForm dto){

        // 1 : 수정용 엔티티 생성
       Student student = dto.toEntity();
        log.info("id: {}, article: {}", id, student.toString());

        // 2: 대상 엔티티를 조회
        Student target = studentRepository.findById(id).orElse(null);

        // 3: 잘못된 요청 처리(대상이 없거나, id가 다른 경우)
        if (target == null || id != student.getId()) {
            // 400, 잘못된 요청 응답
            log.info("잘못된 요청! id: {}, student: {}", id, student.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        

        // 4: 업데이트 및 정상 응답(200)



    }








}
