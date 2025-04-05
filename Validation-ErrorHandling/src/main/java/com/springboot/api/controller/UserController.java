package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.entity.User;
import com.springboot.api.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
@Validated
@Tag(name = "User API", description = "User management operation")  // Swagger documentation
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
     @Operation(summary = "Get all users", description = "Fetches all users from the database")
    public List<User> findAllUsersFromDb() {
        return userService.getAllUsersFromDB();
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "Find user by ID", description = "Fetches a user based on their ID")
    public User findAllUsersById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    @Operation(summary = "Create a new user", description = "Adds a new user with validation checks")
    public String insertUser(@Valid @RequestBody User user) {

        return  userService.insertUser(user);
    }
    

}
  