package com.example.unsss.controller;

import com.example.unsss.dto.StudentDto;
import com.example.unsss.service.StudentService;
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
    public String addStudent(@RequestBody StudentDto student) {
        if (studentService.save(student))
            return "CREATED";
        else
            return "BAD_REQUEST";
    }
}
