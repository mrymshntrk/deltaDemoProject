package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

        TownRepo findCompanyByName(String Name);
}
