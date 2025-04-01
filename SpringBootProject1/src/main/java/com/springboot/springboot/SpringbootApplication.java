package com.springboot.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); 

        SpringApplication.run(SpringbootApplication.class, args);

        long endTime = System.currentTimeMillis(); // Capture end time
        System.out.println("Hello world!!");
        System.out.println("Application started in " + (endTime - startTime) + " ms");
    }
}
