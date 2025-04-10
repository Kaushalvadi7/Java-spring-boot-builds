package com.springboot.application_management_system.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.springboot.application_management_system.Entity.Applicant;

public interface  ApplicantCrudRepository extends ListCrudRepository<Applicant, Long> {
   
}
