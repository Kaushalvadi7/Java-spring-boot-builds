package com.springboot.SpringBootRestfulWs.service;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.springboot.SpringBootRestfulWs.entities.Course;
import com.springboot.SpringBootRestfulWs.repository.CourseRepository;

class CourseServiceImplTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // initializes mocks
    }

    @Test
    void testGetCourses() {
        List<Course> mockCourses = Arrays.asList(
                new Course(1, "Java", "Learn Java"),
                new Course(2, "Spring", "Learn Spring")
        );

        when(courseRepository.getAllCourses()).thenReturn(mockCourses);

        List<Course> result = courseService.getCourses();
        assertEquals(2, result.size());
        verify(courseRepository, times(1)).getAllCourses();
    }

    @Test
    void testGetCourse() {
        Course course = new Course(1, "Java", "Learn Java");
        when(courseRepository.getCourseById(1L)).thenReturn(course);

        Course result = courseService.getCourse(1L);
        assertEquals("Java", result.getTitle());
        verify(courseRepository).getCourseById(1L);
    }

    @Test
    void testAddCourse() {
        Course newCourse = new Course(3, "Docker", "Learn Docker");

        when(courseRepository.addCourse(newCourse)).thenReturn(1);

        Course result = courseService.addCourse(newCourse);
        assertEquals(newCourse, result);
        verify(courseRepository).addCourse(newCourse);
    }

    @Test
    void testUpdateCourse() {
        Course updateCourse = new Course(2, "Spring Boot", "Updated Description");

        when(courseRepository.updateCourse(updateCourse)).thenReturn(1); // returning dummy success

        Course result = courseService.updateCourse(updateCourse);
        assertEquals(updateCourse, result);
        verify(courseRepository).updateCourse(updateCourse);
    }

    @Test
    void testDeleteCourse() {
        long courseId = 1L;
        when(courseRepository.deleteCourse(courseId)).thenReturn(1);

        courseService.deleteCourse(courseId);

        verify(courseRepository, times(1)).deleteCourse(courseId);
    }
}
