package com.sengg4.job_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sengg4.job_portal.model.Job;

public interface JobRepository extends JpaRepository<Job, Long>{
}
