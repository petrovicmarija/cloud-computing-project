package com.example.unsss.service.defaultservice;

import com.example.unsss.dao.StudentDao;
import com.example.unsss.dto.StudentDto;
import com.example.unsss.model.Student;
import com.example.unsss.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class DefaultStudentService implements StudentService {
    private final StudentDao studentDao;

    public DefaultStudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Override
    public Boolean save(StudentDto student) {
        Student newStudent = new Student();
        newStudent.setId(student.getId());
        newStudent.setName(student.getName());
        newStudent.setSurname(student.getSurname());
        newStudent.setIndex(student.getIndex());
        newStudent.setFaculty(student.getFaculty());
        if(studentDao.findByIndexAndFaculty(student.getIndex(), student.getFaculty()).isPresent()) {
            return false;
        } else {
            studentDao.save(newStudent);
            return true;
        }
    }
}
