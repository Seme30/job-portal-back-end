package com.sengg4.job_portal.service.implementation;

import java.util.List;

import com.sengg4.job_portal.exception.ResourceNotFoundException;
import com.sengg4.job_portal.model.JobSeeker;
import com.sengg4.job_portal.service.JobSeekerService;
import com.sengg4.job_portal.repository.JobSeekerRepository;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerServiceImpl implements JobSeekerService{

    private JobSeekerRepository jobSeekerRepository;
    

    public JobSeekerServiceImpl(JobSeekerRepository jobSeekerRepository) {
        super();
        this.jobSeekerRepository = jobSeekerRepository;
    }


    @Override
    public JobSeeker saveJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }


    @Override
    public List<JobSeeker> getAllJobSeekers() {
        return jobSeekerRepository.findAll();
    }


    @Override
    public JobSeeker getJobSeekerById(long id) {
        return jobSeekerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Job Seeker", "Id", id));
    }


    @Override
    public JobSeeker updateJobSeeker(JobSeeker jobSeeker, long id) {
        JobSeeker existingJobSeeker = jobSeekerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Job Seeker", "Id", id));
        existingJobSeeker.setAwardedjob(jobSeeker.getAwardedjob());
        existingJobSeeker.setDateofbirth(jobSeeker.getDateofbirth());
        existingJobSeeker.setWorkExperience(jobSeeker.getWorkExperience());
        existingJobSeeker.setEducationlevel(jobSeeker.getEducationlevel());
        jobSeekerRepository.save(existingJobSeeker);
        return existingJobSeeker;
    }


    @Override
    public void deleteJobSeeker(long id) {
        jobSeekerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Job Seeker", "Id", id));
        jobSeekerRepository.deleteById(id);
 
    }
    
}
