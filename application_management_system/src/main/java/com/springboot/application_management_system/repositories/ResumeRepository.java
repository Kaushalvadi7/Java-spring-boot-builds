package com.springboot.application_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.application_management_system.Entity.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
