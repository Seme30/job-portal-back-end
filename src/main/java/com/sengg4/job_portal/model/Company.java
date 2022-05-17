package com.sengg4.job_portal.model;

import javax.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class Company extends User{

    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CompanyType getCompanytype() {
        return companytype;
    }

    public void setCompanytype(CompanyType companytype) {
        this.companytype = companytype;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="companyType")
    private CompanyType companytype;

    @Column(name="region")
    private String region;
    
    @Column(name="city")
    private String city;

    @OneToMany(targetEntity = Job.class, cascade = CascadeType.ALL)
    private List<Job> jobs;

    @OneToMany(targetEntity = JobApplication.class, cascade = CascadeType.ALL)
    private List<JobApplication> jobApplications;
  
}
