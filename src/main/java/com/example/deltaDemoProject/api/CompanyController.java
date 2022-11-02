package com.example.deltaDemoProject.api;


import com.example.deltaDemoProject.payload.request.CompanyRequest;
import com.example.deltaDemoProject.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api")

public class CompanyController {
    private CompanyService companyService;

    @PostMapping("/company/save")
    public ResponseEntity<String> saveCompany(@Valid @RequestBody CompanyRequest companyRequest){
        return companyService.saveCompany(companyRequest);
    }
}
