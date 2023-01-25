package com.example.unsss.controller;

import com.example.unsss.dto.ProfessorDto;
import com.example.unsss.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/professors")
@CrossOrigin
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public String addProfessor(@RequestBody ProfessorDto professor) {
        if (professorService.save(professor))
            return "CREATED";
        else
            return "BAD_REQUEST";
    }
}
