package com.mybatis.spring_boot_mybatis.mapper;

import org.apache.ibatis.annotations.*;

import com.mybatis.spring_boot_mybatis.model.Student;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM students")
    List<Student> findAll();

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student findById(int id);

    @Insert("INSERT INTO students(name, course, email) VALUES(#{name}, #{course}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student student);

    @Update("UPDATE students SET name=#{name}, course=#{course}, email=#{email} WHERE id=#{id}")
    void update(Student student);

    @Delete("DELETE FROM students WHERE id = #{id}")
    void delete(int id);
}
