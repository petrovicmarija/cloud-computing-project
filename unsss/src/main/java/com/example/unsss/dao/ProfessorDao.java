package com.example.unsss.dao;

import com.example.unsss.model.Professor;
import com.example.unsss.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorDao extends JpaRepository<Professor, Long> {
    Optional<Professor> findByEmailAndFaculty(String email, String faculty);
}
