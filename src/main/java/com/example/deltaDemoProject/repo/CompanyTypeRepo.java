package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.CompanyType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyTypeRepo extends JpaRepository<CompanyType, Long> {

    CompanyType findCompanyTypeByName (String name);
}
