package com.springboot.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "User entity representing a system user")
public class User {

    @Schema(description = "Unique ID of the user", example = "1")
    private Integer id;

    @Schema(description = "Name of the user", example = "kaushal patel")
    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Schema(description = "Address of the user", example = "Jamnagar, Gujarat")
    @NotBlank(message = "Address cannot be empty")
    private String address;

    @Schema(description = "Email Address of the user", example = "kaushal@example.com")
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @Schema(description = "Age of the user", example = "25")
    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be at least 18")
    private int age;   

    @Schema(description = "Salary of the user", example = "50000")
    @NotNull(message = "Salary cannot be null")
    @Min(value = 10000, message = "Salary must be at least 10,000")
    private double salary;



}
