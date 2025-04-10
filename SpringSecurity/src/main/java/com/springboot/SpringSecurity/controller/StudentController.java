package com.springboot.SpringSecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.SpringSecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>( List.of(
            new Student(1, "Jay", 85),
            new Student(2, "Jaymit Soni ", 90)
            
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
    
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);        
        return student;
    }
    
    
   
}
