package com.springboot.application_management_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.application_management_system.Entity.Application;
import com.springboot.application_management_system.service.ApplicationService;


@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/{applicantId}")
    public ResponseEntity<Application> createApplication(@PathVariable Long applicantId, @RequestBody Application application) {
        return ResponseEntity.ok(applicationService.saveApplication(applicantId, application));
    }
    

}
