package com.springboot.application_management_system.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.application_management_system.Entity.Applicant;

public interface ApplicantPagingAndSortingRepository extends PagingAndSortingRepository<Applicant, Long> {

}
