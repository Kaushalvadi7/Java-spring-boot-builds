package com.springboot.spring.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.spring.data.jpa.entity.Guardian;
import com.springboot.spring.data.jpa.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {
    
    @Autowired
    private StudentRepository studentRepository;

    // @Test
    // public void saveStudent() {
    //     Student student = Student.builder()
    //     .emailId("kaushal777@gmail.com")
    //     .firstName("kaushal")
    //     .lastName("patel")
    //     // .guardianName("soham")
    //     // .guardianEmail("soham7777@gmail.com")
    //     // .guardianMobile("1234567890")
    //     .build();

    //     studentRepository.save(student);

    // }

    @Test
    public void savaStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                            .email("nikhil@gmail.com")
                            .name("nikhil")
                            .mobile("1239567890")
                            .build();

        Student student = Student.builder()
                            .firstName("jeet")
                            .lastName("bhatt")
                            .emailId("jeet7777@gmail.com")
                            .guardian(guardian)
                            .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("students = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByfirstName("kaushal");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByfirstNameContaining("so");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("soham");
        System.out.println("students = " + students);
    }

    
}
