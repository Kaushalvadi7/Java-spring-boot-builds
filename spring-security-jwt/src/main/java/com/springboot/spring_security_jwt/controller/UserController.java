package com.springboot.spring_security_jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.spring_security_jwt.entity.User;
import com.springboot.spring_security_jwt.repository.UserRepository;

@RestController("/api")
public class UserController {

@Autowired
private  UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
        
    }
}
