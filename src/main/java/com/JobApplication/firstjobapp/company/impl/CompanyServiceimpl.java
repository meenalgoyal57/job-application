package com.JobApplication.firstjobapp.company.impl;

import com.JobApplication.firstjobapp.company.Company;
import com.JobApplication.firstjobapp.company.CompanyRepository;
import com.JobApplication.firstjobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
