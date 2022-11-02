package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.Department;
import com.example.deltaDemoProject.payload.request.DepartmentRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {

    ResponseEntity<String> saveDepartment(DepartmentRequest departmentRequest);

}
