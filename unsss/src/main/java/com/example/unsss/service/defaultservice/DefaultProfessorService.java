package com.example.unsss.service.defaultservice;

import com.example.unsss.dao.ProfessorDao;
import com.example.unsss.dto.ProfessorDto;
import com.example.unsss.model.Professor;
import com.example.unsss.service.ProfessorService;
import org.springframework.stereotype.Service;

@Service
public class DefaultProfessorService implements ProfessorService {
    private final ProfessorDao professorDao;

    public DefaultProfessorService(ProfessorDao professorDao) {
        this.professorDao = professorDao;
    }

    @Override
    public Boolean save(ProfessorDto professor) {
        Professor newProfessor = new Professor();
        newProfessor.setId(professor.getId());
        newProfessor.setName(professor.getName());
        newProfessor.setSurname(professor.getSurname());
        newProfessor.setFaculty(professor.getFaculty());
        newProfessor.setEmail(professor.getEmail());
        if (professorDao.findByEmailAndFaculty(professor.getEmail(), professor.getFaculty()).isPresent()) {
            return false;
        } else {
            professorDao.save(newProfessor);
            return true;
        }
    }
}
