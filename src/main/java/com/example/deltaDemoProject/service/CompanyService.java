package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.payload.request.CompanyRequest;
import org.springframework.http.ResponseEntity;

public interface CompanyService {

    ResponseEntity<String> saveCompany(CompanyRequest companyRequest);
}
