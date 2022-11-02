package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.*;
import com.example.deltaDemoProject.payload.request.CompanyRequest;
import com.example.deltaDemoProject.repo.CompanyRepo;
import com.example.deltaDemoProject.repo.CompanyTypeRepo;
import com.example.deltaDemoProject.repo.TownRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepo companyRepo;
    private final CompanyTypeRepo companyTypeRepo;
    private final TownRepo townRepo;
    private final UserServiceImpl userServiceImpl;

    @Override
    public ResponseEntity<String> saveCompany(CompanyRequest req) {

        User currentUser = userServiceImpl.getCurrentUser();
        if(!userServiceImpl.isCurrentUserHasRole(ERole.Admin)){
            return ResponseEntity.badRequest().body("Bu islemi yapmak icin yetkiniz yok.");
        }
        CompanyType companyType = companyTypeRepo.findById(req.getCompanyTypeId()).orElse(null);
        if (companyType == null) {
            return ResponseEntity.badRequest().body("böyle bir companyType bulunmamakta");
        }
        Town town = townRepo.findById(req.getTownId()).orElse(null);
        if (town == null) {
            return ResponseEntity.badRequest().body("böyle bir town bulunmuyor");
        }
        Company company = companyRepo.findCompanyByNameAndCompanyType_IdAndAndTown_Id(req.getName(), req.getCompanyTypeId(), req.getTownId());
        if (company != null) {
            return ResponseEntity.badRequest().body("böyle bir company mevcut");
        }

        companyRepo.save(new Company(req.getName(), req.getShortName(), req.getAddressStreet(), companyType, town));
        return ResponseEntity.ok("başarıyla kaydedildi");

        }

    }

