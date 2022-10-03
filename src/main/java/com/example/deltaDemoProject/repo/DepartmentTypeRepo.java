package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.DepartmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentTypeRepo extends JpaRepository<DepartmentType, Integer> {

    DepartmentType findDepartmentTypeByName (String Name);
}
