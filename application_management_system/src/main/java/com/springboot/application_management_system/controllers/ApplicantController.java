package com.springboot.application_management_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.application_management_system.Entity.Applicant;
import com.springboot.application_management_system.service.ApplicantService;



@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;  

    //save applicant
    @PostMapping    
    public Applicant saveApplicant(@RequestBody Applicant applicant) {
        return applicantService.saveApplicant(applicant);
    }

    //get applicant by id
    @GetMapping("/{id}")
    public Applicant getApplicantById(@PathVariable Long id) {
        return applicantService.getApplicantById(id);
    }

    //get all applicants
    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    //delete applicant by id
    @GetMapping("/delete/{id}")
    public void deleteApplicantById(@PathVariable Long id) {
        applicantService.deleteApplicantById(id);
    }

    //delete all applicants
    @GetMapping("/deleteAll")
    public void deleteAllApplicants() {
        applicantService.deleteAllApplicants();
    }

    //get applicants with pagination
    @GetMapping("/page")
    public Iterable<Applicant> getApplicatsWithPagination(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return applicantService.getApplicantsWithPagination(pageNumber, pageSize);
    }

    //get applicants by partial name
    @GetMapping("/name/{name}")
    public List<Applicant> getApplicantByPartialName(@PathVariable String name) {
        return applicantService.getApplicantByPartialName(name);
    }

    //get applicants by status
    @GetMapping("/status/{status}")
    public List<Applicant> getApplicantByStatus(@PathVariable String status) {
        return applicantService.getApplicantByStatus(status);
    }
    
}
