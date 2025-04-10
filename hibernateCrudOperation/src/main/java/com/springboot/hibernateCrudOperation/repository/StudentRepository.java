package com.springboot.hibernateCrudOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hibernateCrudOperation.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
