package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.CompanyType;
import com.example.deltaDemoProject.domain.ERole;
import com.example.deltaDemoProject.domain.User;
import com.example.deltaDemoProject.payload.request.CompanyRequest;
import com.example.deltaDemoProject.payload.request.CompanyTypeRequest;
import com.example.deltaDemoProject.repo.CompanyTypeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CompanyTypeServiceImpl implements CompanyTypeService{

    private final CompanyTypeRepo companyTypeRepo;
    private final UserService userService;
    @Override
    public ResponseEntity<String> saveCompanyType(CompanyTypeRequest req){

        User currentUser = userService.getCurrentUser();
        if(!userService.isCurrentUserHasRole(ERole.Admin)){
            return ResponseEntity.badRequest().body("Bu islemi yapmak icin yetkiniz yok.");
        }
        CompanyType companyType = companyTypeRepo.findCompanyTypeByName(req.getName());
        if (companyType != null) {
            return ResponseEntity.badRequest().body("böyle bir data var");

        }
        companyTypeRepo.save(new CompanyType(req.getName()));
        return ResponseEntity.ok("başarıyla kaydedildi");
    }
    public List<CompanyType> getCompanyType(){
        return companyTypeRepo.findAll();
    }
}
