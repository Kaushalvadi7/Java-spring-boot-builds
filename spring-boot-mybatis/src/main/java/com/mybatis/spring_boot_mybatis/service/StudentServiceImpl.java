package com.mybatis.spring_boot_mybatis.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.spring_boot_mybatis.mapper.StudentMapper;
import com.mybatis.spring_boot_mybatis.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper mapper;

    @Override
    public List<Student> getAll() {
        return mapper.findAll();
    }

    @Override
    public Student getById(int id) {
        return mapper.findById(id);
    }

    @Override
    public void save(Student student) {
        mapper.insert(student);
    }

    @Override
    public void update(Student student) {
        mapper.update(student);
    }

    @Override
    public void delete(int id) {
        mapper.delete(id);
    }
}
