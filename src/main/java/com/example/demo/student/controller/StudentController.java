package com.example.demo.student.controller;

import com.example.demo.student.model.StudentModel;
import com.example.demo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController is een gespecialiseerde versie van de controller
//Het bevat de annotaties @Controller en @ResponseBody en verinvoudigt
//daardoor de implementatie van de controller /

@RestController
@RequestMapping({"api/v1/student"})
public class StudentController {

    @Autowired
    private StudentService studentService;
    public StudentController(){}

    @GetMapping
    public List<StudentModel> getStudent() {
        return studentService.getStudent();
    }

    @PostMapping("/savestudent")
    public void registerNewStudent(@RequestBody StudentModel student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = {"{studentId}"}) // search num 1
    //@DeleteMapping(path = "id={studentId}")  - search id
    public void deleteStudent (@PathVariable("studentId")Long studentId){
        studentService.deleteStudent(studentId);
    }
}
