package com.springboot.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.entity.User;
import com.springboot.api.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAllUsersFromDb() {
        return userService.getAllUsersFromDB();
    }

    @GetMapping("/user/{id}")
    public User findAllUsersById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public String insertUser(@Valid @RequestBody User user) {

        return  userService.insertUser(user);
    }
    

}
  