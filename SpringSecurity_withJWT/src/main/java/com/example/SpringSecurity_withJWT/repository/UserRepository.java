package com.example.SpringSecurity_withJWT.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    com.example.SpringSecurity_withJWT.model.User findByUsername(String username);
}
