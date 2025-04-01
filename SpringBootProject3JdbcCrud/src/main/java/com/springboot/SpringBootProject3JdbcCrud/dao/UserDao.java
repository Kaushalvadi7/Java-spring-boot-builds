package com.springboot.SpringBootProject3JdbcCrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.SpringBootProject3JdbcCrud.entity.User;

// Repository layer for CRUD operations

@Repository
public class UserDao {

    @Autowired 
    private JdbcTemplate jdbcTemplate;

    public boolean insertUser(User user){

        boolean status = false;

        try {
            String INSERT_SQL_QUERY = "INSERT INTO users(name, email, gender, city) VALUES(?, ?, ?, ?)";
        int count = jdbcTemplate.update(INSERT_SQL_QUERY, user.getName(), user.getEmail(), user.getGender(), user.getCity());

        if(count > 0){
            status = true;
        }else{
            status = false;
        }
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
        
    }

    public boolean updateUser(User user){

        boolean status = false;

        try {
            String Update_SQL_Query = "UPDATE users SET name =?, gender =?, city =? WHERE email = ?";
            int count = jdbcTemplate.update(Update_SQL_Query, user.getName(), user.getGender(), user.getCity(), user.getEmail());
            if(count > 0){
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }

        return status;

    }

    public boolean deleteUserByEmail(String email){

        boolean status = false;

        try {
            String Delete_SQL_Query = "DELETE FROM users WHERE email = ?";
            int count = jdbcTemplate.update(Delete_SQL_Query, email );
            if(count > 0){
                status = true;
            }else{
                status = false;
            }
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }

        return status;

    }
}
