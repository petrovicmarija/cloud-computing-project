package com.example.unsss.dao;

import com.example.unsss.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
}
