package com.springboot.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springdoc.core.models.GroupedOpenApi;

@Configuration
@Profile({"dev"})  // Only load this configuration for dev profiles
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/**") // Change the base path if needed
                .build();
    }

    @Bean
    public OpenAPI myCustomConfig() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Spring Boot API")
                        .description("By Kaushal")
                        .version("1.0.0"));
    }
}
