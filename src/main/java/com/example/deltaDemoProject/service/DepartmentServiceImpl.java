package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.*;
import com.example.deltaDemoProject.payload.request.DepartmentRequest;
import com.example.deltaDemoProject.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepo departmentRepo;
    private final CompanyRepo companyRepo;
    private final DepartmentTypeRepo departmentTypeRepo;
    private final TownRepo townRepo;
    private final UserServiceImpl userServiceImpl;
    @Override
    public ResponseEntity<String> saveDepartment(DepartmentRequest req){

        User currentUser = userServiceImpl.getCurrentUser();
        if(!userServiceImpl.isCurrentUserHasRole(ERole.Admin)){
            return ResponseEntity.badRequest().body("Bu islemi yapmak icin yetkiniz yok.");
        }
        Company company = companyRepo.findById(req.getCompanyId()).orElse(null);
        if (company == null) {
            return ResponseEntity.badRequest().body("böyle bir company bulunamadı");
        }
        DepartmentType departmentType= departmentTypeRepo.findById(req.getDepartmentTypeId()).orElse(null);
        if (departmentType == null) {
            return ResponseEntity.badRequest().body("böyle bir departmentType bulunamadı");
        }
        Town town = townRepo.findById(req.getTownId()).orElse(null);
        if(town == null){
            return ResponseEntity.badRequest().body("böyle bir town bulunamadı.");
        }
        Department department = departmentRepo.findDepartmentByNameAndCompany_IdAndDepartmentType_IdAndTown_Id(req.getName(), req.getCompanyId(), req.getDepartmentTypeId(), req.getTownId());
        if (department != null) {
            return ResponseEntity.badRequest().body("böyle bir department mevcut");
        }

        departmentRepo.save(new Department(req.getName(),
                req.getAddressStreet(),
                company, departmentType, town));
        return ResponseEntity.ok("kayıt başarılı");
    }

}
