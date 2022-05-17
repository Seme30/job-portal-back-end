package com.sengg4.job_portal.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;


@Data
@Entity 
@Table(name="Job")
public class Job {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public List<JobApplication> getJobApplications() {
        return jobApplications;
    }

    public void setJobApplications(List<JobApplication> jobApplications) {
        this.jobApplications = jobApplications;
    }

    public JobCategory getJobcategory() {
        return jobcategory;
    }

    public void setJobcategory(JobCategory jobcategory) {
        this.jobcategory = jobcategory;
    }

    public int getVacancy() {
        return vacancy;
    }

    public void setVacancy(int vacancy) {
        this.vacancy = vacancy;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getPosteddate() {
        return posteddate;
    }

    public void setPosteddate(Date posteddate) {
        this.posteddate = posteddate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "companyname")
    private String companyname;

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getJobtype() {
        return jobtype;
    }

    public void setJobtype(String jobtype) {
        this.jobtype = jobtype;
    }

    @Column(name="jobtype")
    private String jobtype;
    
    @OneToOne(targetEntity = JobSeeker.class, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private JobSeeker jobSeeker;

    @OneToMany(targetEntity = JobApplication.class, cascade = CascadeType.ALL) 
    private List<JobApplication> jobApplications;

    @Column(name = "jobcategory")
    @Enumerated(EnumType.STRING)
    private JobCategory jobcategory;

    @Column(name = "vacancy")
    private int vacancy;

    @Column(name = "salary")
    private String salary;

    @Column(name = "posteddate")
    private Date posteddate;

    @Column(name="deadline")
    private Date deadline;
    
    @Column(name = "status")
    private Boolean status;
}
