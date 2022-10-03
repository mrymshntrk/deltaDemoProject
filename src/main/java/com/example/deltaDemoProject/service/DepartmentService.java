package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.Department;

public interface DepartmentService {

    Department saveDepartment(Department department);

    void addCompanyToDepartment(String departmentName, String companyName);
    void addDepartmentTypeToDepartment(String departmentName, String departmentTypeName);

}
