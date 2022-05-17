package com.sengg4.job_portal.model;
import java.util.Date;

import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class JobSeeker extends User{

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "dateofbirth")
    private Date dateofbirth;

    @Enumerated(EnumType.STRING)
    @Column(name="educationlevel")
    private EducationLevel educationlevel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public EducationLevel getEducationlevel() {
        return educationlevel;
    }

    public void setEducationlevel(EducationLevel educationlevel) {
        this.educationlevel = educationlevel;
    }

    public Job getAwardedjob() {
        return awardedjob;
    }

    public void setAwardedjob(Job awardedjob) {
        this.awardedjob = awardedjob;
    }

    public List<WorkExperience> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<WorkExperience> workExperience) {
        this.workExperience = workExperience;
    }

    @OneToOne(targetEntity = Job.class, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.DETACH})
    private Job awardedjob;

    @OneToMany(targetEntity = WorkExperience.class)
	private List<WorkExperience> workExperience;
}
