package com.example.demo.student.service;

import com.example.demo.student.model.Student;
import com.example.demo.student.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {

    private final IStudentRepository studentRepository;
    //nadat we annotatie-injectie hebben ingeschakeld,
    //kunnen we autowiring gebruiken voor eigenschappen , setters en constructors
@Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
        //return List.of (1l, "Mariam","mariam@gmail.com",
        // LocalDate.of(2000,Mont.JANUARY,5)21));
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (exists) {
            throw new IllegalStateException("student id" + studentId + "does not exist");
        }
        studentRepository.deleteById(studentId);
    }
}
