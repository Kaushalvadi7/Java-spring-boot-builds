package com.springboot.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EnvironmentService {

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    private final Environment environment;

    public EnvironmentService(Environment environment) {
        this.environment = environment;
    }

    public void printDatabaseCredentials() {
        System.out.println("====================================");
        System.out.println(" Active Profile: " + activeProfile);
        System.out.println(" Database Username: " + dbUsername);
        System.out.println(" Database Password: " + dbPassword);
        System.out.println("====================================");
    }
}
