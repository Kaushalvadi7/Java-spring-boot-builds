package com.springboot.spring.data.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coursematerial {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY)
    private Long courseMaterialId;
    private String url;

    @OneToOne
    private Course course;
}


