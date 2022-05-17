package com.sengg4.job_portal.repository;

import com.sengg4.job_portal.model.JobSeeker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>{
    
}
