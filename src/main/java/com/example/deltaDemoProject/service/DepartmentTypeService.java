package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.DepartmentType;
import com.example.deltaDemoProject.payload.request.DepartmentTypeRequest;
import org.springframework.http.ResponseEntity;

public interface DepartmentTypeService {

    ResponseEntity<String> saveDepartmentType(DepartmentTypeRequest departmentTypeRequest);
}
