package com.springboot.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.api.service.EnvironmentService;

@SpringBootApplication
public class ValidationErrorHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationErrorHandlingApplication.class, args);
	}

	 @Bean
    CommandLineRunner displayDatabaseCredentials(EnvironmentService environmentService) {
        return args -> {
            environmentService.printDatabaseCredentials();
        };
    }
}
