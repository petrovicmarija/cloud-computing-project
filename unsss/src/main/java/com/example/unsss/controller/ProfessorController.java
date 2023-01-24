package com.example.unsss.controller;

import com.example.unsss.dto.ProfessorDto;
import com.example.unsss.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "professors")
@CrossOrigin
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<ProfessorDto> addProfessor(@RequestBody ProfessorDto professor) {
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }
}
