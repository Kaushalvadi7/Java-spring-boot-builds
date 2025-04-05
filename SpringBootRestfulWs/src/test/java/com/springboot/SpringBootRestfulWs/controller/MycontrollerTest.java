package com.springboot.SpringBootRestfulWs.controller;

import com.springboot.SpringBootRestfulWs.entities.Course;
import com.springboot.SpringBootRestfulWs.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType; // ✅ REQUIRED IMPORT
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(Mycontroller.class)
public class MycontrollerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/api/home"))
                .andExpect(status().isOk())
                .andExpect(content().string("Welcome to Courses Application"));
    }

    @Test
    public void testGetCourses() throws Exception {
        List<Course> courses = Arrays.asList(
                new Course(1, "Java", "Java Basics"),
                new Course(2, "Spring Boot", "REST APIs")
        );

        when(courseService.getCourses()).thenReturn(courses);

        mockMvc.perform(get("/api/courses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(courses.size()));
    }

    @Test
    public void testAddCourse() throws Exception {
        Course course = new Course(3, "Docker", "Containerization");
        when(courseService.addCourse(any(Course.class))).thenReturn(course);

        String json = """
            {
                "id": 3,
                "title": "Docker",
                "description": "Containerization"
            }
        """;

        mockMvc.perform(post("/api/courses")
                        .contentType(MediaType.APPLICATION_JSON) // ✅ FIXED HERE
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Docker"));
    }

    @Test
    public void testGetCourseById_Found() throws Exception {
        Course course = new Course(1, "Java", "Core Java");

        when(courseService.getCourse(1L)).thenReturn(course);

        mockMvc.perform(get("/api/courses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Java"));
    }

    @Test
    public void testUpdateCourse() throws Exception {
        Course course = new Course(1, "Updated Java", "Updated Description");
        when(courseService.updateCourse(any(Course.class))).thenReturn(course);

        String json = """
            {
                "id": 1,
                "title": "Updated Java",
                "description": "Updated Description"
            }
        """;

        mockMvc.perform(put("/api/courses")
                        .contentType(MediaType.APPLICATION_JSON) // ✅ FIXED HERE
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated Java"));
    }

    @Test
    public void testGetCourseById_NotFound() throws Exception {
        when(courseService.getCourse(1L)).thenReturn(null);

        mockMvc.perform(get("/api/courses/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteCourse() throws Exception {
        doNothing().when(courseService).deleteCourse(1L);

        mockMvc.perform(delete("/api/courses/1"))
                .andExpect(status().isOk());
    }
}
