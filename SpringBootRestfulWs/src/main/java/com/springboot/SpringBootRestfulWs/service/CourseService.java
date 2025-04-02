package com.springboot.SpringBootRestfulWs.service;

import java.util.List;

import com.springboot.SpringBootRestfulWs.entities.Course;

public interface CourseService {

    public List<Course> getCourses(); //get all courses

    public Course getCourse(Long  courseId); //get course by id

    public Course addCourse(Course course); //add course

    public Course updateCourse(Course course); //update course

    public void deleteCourse(Long courseId); //delete course by id
}
