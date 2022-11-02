package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
        Company findCompanyByNameAndCompanyType_IdAndAndTown_Id(String name,
                                                                Long companyTypeId, Long townId);

}
