package com.sengg4.job_portal.service.implementation;
import java.util.List;

import com.sengg4.job_portal.model.Job;
import com.sengg4.job_portal.repository.JobRepository;
import com.sengg4.job_portal.service.JobService;

import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService{

    private JobRepository JobRepository;

    
    public JobServiceImpl(com.sengg4.job_portal.repository.JobRepository jobRepository) {
        JobRepository = jobRepository;
    }


    @Override
    public List<Job> getAllJobs() {   
        return JobRepository.findAll();
    }


    @Override
    public Job saveJob(Job job) {
        return JobRepository.save(job);
    }



}