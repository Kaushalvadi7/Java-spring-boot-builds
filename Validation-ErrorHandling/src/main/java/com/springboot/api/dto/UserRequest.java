package com.springboot.api.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String address;
    private String email;
    private int age;   
    private double salary;
}
