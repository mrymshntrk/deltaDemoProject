package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.Company;
import com.example.deltaDemoProject.repo.CompanyRepo;
import com.example.deltaDemoProject.repo.DepartmentRepo;
import com.example.deltaDemoProject.repo.TownRepo;
import com.example.deltaDemoProject.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class CompanyServiceImpl implements CompanyService{

    private final UserRepo userRepo;
    private final DepartmentRepo departmentRepo;
    private final TownRepo townRepo;
    private final CompanyRepo companyRepo;

    @Override
    public Company saveCompany(Company company) {
        return null;
    }

    @Override
    public void addCompanyTypeToCompany(String companyName, String companyTypeName) {

    }

    @Override
    public void addTownToCompany(String companyName, String townName) {

    }
}
