package com.mybatis.spring_boot_mybatis.model;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private String course;
    private String email;
}