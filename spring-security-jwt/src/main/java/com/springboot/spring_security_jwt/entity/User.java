package com.springboot.spring_security_jwt.entity;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private int id;
    private String username;
    private String password;

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
