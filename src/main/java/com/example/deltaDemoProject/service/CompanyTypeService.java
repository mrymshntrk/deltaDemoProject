package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.payload.request.CompanyRequest;
import com.example.deltaDemoProject.payload.request.CompanyTypeRequest;
import org.springframework.http.ResponseEntity;

public interface CompanyTypeService {

    ResponseEntity<String> saveCompanyType(CompanyTypeRequest companyTypeRequest);

}
