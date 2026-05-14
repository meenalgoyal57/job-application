package com.JobApplication.firstjobapp.company.impl;

import com.JobApplication.firstjobapp.company.Company;
import com.JobApplication.firstjobapp.company.CompanyRepository;
import com.JobApplication.firstjobapp.company.CompanyService;
import com.JobApplication.firstjobapp.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceimpl implements CompanyService {
private CompanyRepository companyRepository;

    public CompanyServiceimpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }


    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companytoupdate = companyOptional.get();
            companytoupdate.setDescription(company.getDescription());
            companytoupdate.setName(company.getName());
            companytoupdate.setJobs(company.getJobs());
            companyRepository.save(companytoupdate);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id){
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
            return false;

    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }


}


