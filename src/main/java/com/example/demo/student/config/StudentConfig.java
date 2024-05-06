package com.example.demo.student.config;

import com.example.demo.student.model.StudentModel;
import com.example.demo.student.repository.IStudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(IStudentRepository repository) {

        return (args) -> {
            StudentModel mariam = new StudentModel("Mariam", "mariam@gmail.com", LocalDate.of(2000, Month.JANUARY, 5));
            StudentModel alex = new StudentModel("Alex", "alex@gmail.com", LocalDate.of(2004, Month.JANUARY, 5));
            repository.saveAll(List.of(mariam, alex));
        };
    }

}
