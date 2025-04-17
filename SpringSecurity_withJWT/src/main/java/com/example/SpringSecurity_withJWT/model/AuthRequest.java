package com.example.SpringSecurity_withJWT.model;


import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}

