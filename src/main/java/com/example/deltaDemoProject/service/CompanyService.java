package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.Company;

public interface CompanyService {

    Company saveCompany(Company company);

    void addCompanyTypeToCompany(String companyName, String companyTypeName);
    void addTownToCompany(String companyName, String townName);

}
