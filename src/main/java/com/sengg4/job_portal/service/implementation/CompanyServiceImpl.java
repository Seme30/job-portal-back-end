package com.sengg4.job_portal.service.implementation;

import java.util.List;

import com.sengg4.job_portal.exception.ResourceNotFoundException;
import com.sengg4.job_portal.model.Company;
import com.sengg4.job_portal.repository.CompanyRespository;
import com.sengg4.job_portal.service.CompanyService;

import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

    private CompanyRespository companyRepository;
    

    public CompanyServiceImpl(CompanyRespository companyRespository) {
        this.companyRepository = companyRespository;
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Company", "Id", id));
    }

    @Override
    public Company updateCompany(Company company, long id) {
        Company existingCompany = companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Company", "Id", id));
        existingCompany.setCity(company.getCity());
        existingCompany.setCompanytype(company.getCompanytype());
        existingCompany.setJobs(company.getJobs());
        existingCompany.setJobApplications(company.getJobApplications());
        companyRepository.save(existingCompany);
        return existingCompany;
    }

    @Override
    public void deleteCompany(long id) {
        companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Company", "Id", id));
        companyRepository.deleteById(id);
        
    }
    
}
