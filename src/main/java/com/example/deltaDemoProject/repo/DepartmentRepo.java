package com.example.deltaDemoProject.repo;


import com.example.deltaDemoProject.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

    Department findDepartmentByNameAndCompany_IdAndDepartmentType_IdAndTown_Id (
            String name,
            Long companyId,
            Long departmentTypeId,
            Long townId);


}
