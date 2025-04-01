package com.springboot.SpringBootRestfulWs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

    @GetMapping("/home")
    public String home(){
        return "Welcome to courses application";
    }

    //get the courses
    @GetMapping("/courses")
    public List<Courses> getCourses(){
        
    }

}
