package com.mybatis.spring_boot_mybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Student Management API")
                .version("1.0.0")
                .description("API documentation for managing students using MyBatis and Spring Boot."));
    }

    // Swagger UI can be accessed at the following URL:
    //http://localhost:8080/swagger-ui/index.html
}
