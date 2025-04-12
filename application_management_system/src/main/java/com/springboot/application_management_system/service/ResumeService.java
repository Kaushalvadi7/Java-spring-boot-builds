package com.springboot.application_management_system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.application_management_system.Entity.Applicant;
import com.springboot.application_management_system.Entity.Resume;
import com.springboot.application_management_system.repositories.ApplicantJpaRepository;
import com.springboot.application_management_system.repositories.ResumeRepository;

@Service
public class ResumeService {
    @Autowired
    ResumeRepository resumeRepository;

    @Autowired
    ApplicantJpaRepository applicantJpaRepository;

    public Resume addResume(Long applicantId, Resume resume){
        Optional<Applicant> applicantOptional = applicantJpaRepository.findById(applicantId);
        if (applicantOptional.isPresent()) {
            Applicant applicant = applicantOptional.get();
            resume.setApplicant(applicant);
            return resumeRepository.save(resume);
        } else {
            throw new RuntimeException("Applicant not found with id: " + applicantId);
        }
    }

}
