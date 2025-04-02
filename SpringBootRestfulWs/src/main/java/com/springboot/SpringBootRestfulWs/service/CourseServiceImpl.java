package com.springboot.SpringBootRestfulWs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.SpringBootRestfulWs.entities.Course;
import com.springboot.SpringBootRestfulWs.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course getCourse(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        courseRepository.addCourse(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        courseRepository.updateCourse(course);
        return course;
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteCourse(courseId);
    }
}
