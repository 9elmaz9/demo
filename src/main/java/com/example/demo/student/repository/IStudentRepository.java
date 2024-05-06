package com.example.demo.student.repository;

import com.example.demo.student.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<StudentModel, Long> {
    //om SQL te definieeren die moet worden uitgevoerd voor een spring data-resopitorymethode,
    //kunnen we de methode annoteren met de @Query -annotatie:
    //het waarde-attribuut bevat de JPQL of SQL die moet worden uitgevoeren

    @Query("SELECT s FROM StudentModel s WHERE s.email=?1")
    Optional<StudentModel> findStudentByEmail(String email);

}
