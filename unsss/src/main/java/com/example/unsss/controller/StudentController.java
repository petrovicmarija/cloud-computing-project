package com.example.unsss.controller;

import com.example.unsss.dto.StudentDto;
import com.example.unsss.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students")
@CrossOrigin
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto student) {
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
