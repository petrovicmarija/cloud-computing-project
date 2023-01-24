package com.example.unsss.dao;

import com.example.unsss.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentDao extends JpaRepository<Student, Long> {
    Optional<Student> findByIndexAndFaculty(String index, String faculty);
}
