package com.springboot.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.api.entity.User;
import com.springboot.api.exception.UserNotFoundException;
import com.springboot.api.repo.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User getUserById(int id) {
        Optional<User> user = userRepo.findById(id);
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    public List<User> getAllUsersFromDB() {
        return userRepo.findAll();
    }

    public String insertUser(User user) {
        int result = userRepo.save(user);
        return result > 0 ? "User inserted successfully" : "Error inserting user";
    }
}
