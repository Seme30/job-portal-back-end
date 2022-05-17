package com.sengg4.job_portal.service;

import java.util.List;

import com.sengg4.job_portal.model.JobSeeker;

public interface JobSeekerService {
    JobSeeker saveJobSeeker(JobSeeker jobSeeker);
    List<JobSeeker> getAllJobSeekers();
    JobSeeker getJobSeekerById(long id);
    JobSeeker updateJobSeeker(JobSeeker jobSeeker, long id);
    void deleteJobSeeker(long id);
}
