package com.springboot.application_management_system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.application_management_system.Entity.Applicant;
import com.springboot.application_management_system.Entity.Application;
import com.springboot.application_management_system.repositories.ApplicantJpaRepository;
import com.springboot.application_management_system.repositories.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    ApplicantJpaRepository applicantJpaRepository;

    @Autowired
    private ApplicationRepository applicationRepository; 

    public Application saveApplication(Long applicantId, Application application) {
        Optional<Applicant> applicantOptional = applicantJpaRepository.findById(applicantId);
        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            application.setApplicant(applicant);
            return applicationRepository.save(application);
        } else {
            throw new RuntimeException("Applicant not found with id: " + applicantId);
        }
    }
}
