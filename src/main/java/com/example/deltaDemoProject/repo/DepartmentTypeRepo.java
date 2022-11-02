package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.DepartmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentTypeRepo extends JpaRepository<DepartmentType, Long> {

    DepartmentType findDepartmentTypeByName (String name);
}
