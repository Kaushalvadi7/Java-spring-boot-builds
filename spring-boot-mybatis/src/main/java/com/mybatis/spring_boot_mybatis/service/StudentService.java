package com.mybatis.spring_boot_mybatis.service;
import java.util.List;

import com.mybatis.spring_boot_mybatis.model.Student;

public interface StudentService {
    List<Student> getAll();
    Student getById(int id);
    void save(Student student);
    void update(Student student);
    void delete(int id);
}
