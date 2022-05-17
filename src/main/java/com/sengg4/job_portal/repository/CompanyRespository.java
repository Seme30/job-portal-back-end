package com.sengg4.job_portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sengg4.job_portal.model.Company;

public interface CompanyRespository extends JpaRepository<Company, Long>{
    
}
