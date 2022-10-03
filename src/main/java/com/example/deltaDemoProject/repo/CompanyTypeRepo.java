package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.CompanyType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyTypeRepo extends JpaRepository<CompanyType, Integer> {

    CompanyType findCompanyTypeByName (String Name);
}
