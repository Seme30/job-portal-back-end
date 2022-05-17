package com.sengg4.job_portal.controller;

import java.util.List;

import com.sengg4.job_portal.model.JobSeeker;
import com.sengg4.job_portal.service.JobSeekerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/jobseekers")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        super();
        this.jobSeekerService = jobSeekerService;
    }
    
    //Create a jobseeker
    @PostMapping()
    public ResponseEntity<JobSeeker> saveJobSeeker(@RequestBody JobSeeker jobSeeker){
        return new ResponseEntity<JobSeeker>(jobSeekerService.saveJobSeeker(jobSeeker), HttpStatus.CREATED);
    }

    //Retreive all job seekers
        @GetMapping
        public List<JobSeeker> getAllJobSeekers(){
            return jobSeekerService.getAllJobSeekers();
        }
    
        //retreive jobseekers by id
        @GetMapping("{id}")
        public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable("id") long Id){
            return new ResponseEntity<JobSeeker>(jobSeekerService.getJobSeekerById(Id),HttpStatus.OK);
        }
    
        //update job seekers
        @PutMapping("{id}")
        public ResponseEntity<JobSeeker> updateUser(@RequestBody JobSeeker jobSeeker, @PathVariable("id") long Id){
            return new ResponseEntity<JobSeeker>(jobSeekerService.updateJobSeeker(jobSeeker, Id), HttpStatus.OK);
        }
    


    
}
