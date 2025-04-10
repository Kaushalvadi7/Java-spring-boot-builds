package com.springboot.application_management_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.application_management_system.Entity.Applicant;

public interface ApplicantJpaRepository extends JpaRepository<Applicant, Long> {

    
    List<Applicant> findByStatusOrderByNameAsc(String status); // Custom query method to find applicants by status and sort by name in ascending order

    @Query("SELECT a FROM Applicant a WHERE a.name LIKE %:name%")
    List<Applicant> findApplicantsByPartialName(@Param("name")String name); // Custom query using JPQL to find applicants by partial name

}
