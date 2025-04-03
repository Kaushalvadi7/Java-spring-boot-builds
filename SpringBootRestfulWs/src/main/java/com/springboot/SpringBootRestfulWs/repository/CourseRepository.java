package com.springboot.SpringBootRestfulWs.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.SpringBootRestfulWs.entities.Course;

@Repository
public class CourseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Fetch all courses
    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, new CourseRowMapper());
    }

    // Fetch course by ID
    public Course getCourseById(Long id) {
        String sql = "SELECT * FROM courses WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new CourseRowMapper(), id);
    }

    // Insert new course
    public int addCourse(Course course) {
        String sql = "INSERT INTO courses (title, description) VALUES (?, ?)";
        return jdbcTemplate.update(sql, course.getTitle(), course.getDescription());
    }

    // Update existing course
    public int updateCourse(Course course) {
        String sql = "UPDATE courses SET title = ?, description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getId());
    }

    // Delete course by ID 
    public int deleteCourse(Long id) {
        String sql = "DELETE FROM courses WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    // RowMapper to map SQL rows to Java Objects
    private static class CourseRowMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Course(rs.getLong("id"), rs.getString("title"), rs.getString("description"));
        }
    }
}
