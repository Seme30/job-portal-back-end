package com.sengg4.job_portal.controller;

import java.util.List;

import com.sengg4.job_portal.model.Company;
import com.sengg4.job_portal.service.CompanyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        super();
        this.companyService = companyService;
    }

     //Retreive all companies
     @GetMapping
     public List<Company> getAllCompanies(){
         return companyService.getAllCompanies();
     }
 
     //retreive companies by id
     @GetMapping("{id}")
     public ResponseEntity<Company> getCompanyById(@PathVariable("id") long Id){
         return new ResponseEntity<Company>(companyService.getCompanyById(Id),HttpStatus.OK);
     }
 
     //update company
     @PutMapping("{id}")
     public ResponseEntity<Company> updateUser(@RequestBody Company company, @PathVariable("id") long Id){
         return new ResponseEntity<Company>(companyService.updateCompany(company, Id), HttpStatus.OK);
     }
 
     //delete user
     @DeleteMapping({"id"})
     public ResponseEntity<String> deleteUser(@PathVariable("id") long Id){
        companyService.deleteCompany(Id);
         return new ResponseEntity<String>("Company deleted successfully.!", HttpStatus.OK);
     }
    

} 