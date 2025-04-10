package com.springboot.application_management_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springboot.application_management_system.Entity.Applicant;
import com.springboot.application_management_system.repositories.ApplicantCrudRepository;
import com.springboot.application_management_system.repositories.ApplicantJpaRepository;
import com.springboot.application_management_system.repositories.ApplicantPagingAndSortingRepository;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantCrudRepository applicantCrudRepository;

    @Autowired
    private ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository;

    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;

    public List<Applicant> getAllApplicants() {
    List<Applicant> applicantList = new ArrayList<>();
    return applicantCrudRepository.findAll();
    }

    public Applicant getApplicantById(Long id) {
        return applicantCrudRepository.findById(id).orElse(null);
    }

    public List<Applicant> getApplicantByStatus(String status) {
        return applicantJpaRepository.findByStatusOrderByNameAsc(status);
    }

    public List<Applicant> getApplicantByPartialName(String name) {
        return applicantJpaRepository.findApplicantsByPartialName(name);
    }

    public void deleteApplicantById(Long id) {
        applicantCrudRepository.deleteById(id);
    }

    public void deleteAllApplicants() {
        applicantCrudRepository.deleteAll();
    }   

    public Applicant saveApplicant(Applicant applicant) {
        return applicantCrudRepository.save(applicant); 
    }

    public Iterable<Applicant> getApplicantsWithPagination(int pageNumber, int pageSize) {
        return applicantPagingAndSortingRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }
}
