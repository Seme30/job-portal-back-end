package com.sengg4.job_portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.sengg4.job_portal.model.Job;
import com.sengg4.job_portal.service.JobService;

@RestController
@RequestMapping("api/jobs")
public class JobController {
    
    private JobService jobService;

    public JobController(JobService jobService) {
        super();
        this.jobService = jobService;
    }

    //Creates Job
    @PostMapping(consumes={"application/json"})
    public ResponseEntity<Job> saveUser(@RequestBody Job job){
        System.out.println(job.getTitle());
        return new ResponseEntity<Job>(jobService.saveJob(job), HttpStatus.CREATED);
    }

    //Get All jobs
    @GetMapping
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

}
