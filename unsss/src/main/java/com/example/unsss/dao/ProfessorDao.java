package com.example.unsss.dao;

import com.example.unsss.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorDao extends JpaRepository<Professor, Long> {
}
