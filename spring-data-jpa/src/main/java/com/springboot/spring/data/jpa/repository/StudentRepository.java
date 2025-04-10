package com.springboot.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.spring.data.jpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByfirstName(String firstName);

    List<Student> findByfirstNameContaining(String name);

    List<Student> findByLastNameNotNull(String lastName);

    List<Student> findByGuardianName(String guardianName);


   
}
