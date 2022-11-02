package com.example.deltaDemoProject.api;

import com.example.deltaDemoProject.payload.request.CompanyTypeRequest;
import com.example.deltaDemoProject.service.CompanyTypeService;
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
public class CompanyTypeController {
    private CompanyTypeService companyTypeService;

    @PostMapping("/companyType/save")
    public ResponseEntity<String> saveCompanyType(@Valid @RequestBody CompanyTypeRequest companyTypeRequest){
        return companyTypeService.saveCompanyType(companyTypeRequest);
    }
}
