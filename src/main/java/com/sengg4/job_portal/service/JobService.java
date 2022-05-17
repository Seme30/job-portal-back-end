package com.sengg4.job_portal.service;
import java.util.List;

import com.sengg4.job_portal.model.Job;
public interface JobService {
    Job saveJob(Job job);
    List<Job> getAllJobs();
}
