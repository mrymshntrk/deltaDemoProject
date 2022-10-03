package com.example.deltaDemoProject.repo;


import com.example.deltaDemoProject.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    Department findDepartmentByName (String Name);
}
