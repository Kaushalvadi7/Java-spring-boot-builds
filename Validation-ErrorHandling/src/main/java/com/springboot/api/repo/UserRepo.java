package com.springboot.api.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.api.entity.User;

@Repository
public class UserRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Fetch all users
    public List<User> findAll() {
        String sql = "SELECT * FROM usertable";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    // Fetch user by ID
    public Optional<User> findById(int id) {
        String sql = "SELECT * FROM usertable WHERE id = ?";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), id);
        return users.isEmpty() ? Optional.empty() : Optional.of(users.get(0));
    }

    // Insert a new user
    public int save(User user) {
        String sql = "INSERT INTO usertable (name, address, email, age, salary) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getAddress(), user.getEmail(), user.getAge(), user.getSalary());
    }
}

// RowMapper to map database result set to User object
class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAddress(rs.getString("address"));
        user.setEmail(rs.getString("email"));
        user.setAge(rs.getInt("age"));
        user.setSalary(rs.getDouble("salary"));
        return user;
    }
}
