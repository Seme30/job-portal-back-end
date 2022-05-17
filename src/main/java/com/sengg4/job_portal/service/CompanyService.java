package com.sengg4.job_portal.service;

import java.util.List;

import com.sengg4.job_portal.model.Company;

public interface CompanyService {
    Company saveCompany(Company company);
    List<Company> getAllCompanies();
    Company getCompanyById(long id);
    Company updateCompany(Company company, long id);
    void deleteCompany(long id);
}
