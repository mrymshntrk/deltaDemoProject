package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.DepartmentType;
import com.example.deltaDemoProject.domain.ERole;
import com.example.deltaDemoProject.domain.User;
import com.example.deltaDemoProject.payload.request.DepartmentTypeRequest;
import com.example.deltaDemoProject.repo.DepartmentTypeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DepartmentTypeServiceImpl implements DepartmentTypeService{

    private final DepartmentTypeRepo departmentTypeRepo;
    private final UserService userService;
    @Override
    public ResponseEntity<String> saveDepartmentType(DepartmentTypeRequest req){

        User currentUser = userService.getCurrentUser();
        if(!userService.isCurrentUserHasRole(ERole.Admin)){
            return ResponseEntity.badRequest().body("Bu islemi yapmak icin yetkiniz yok.");
        }

        DepartmentType departmentType=departmentTypeRepo.findDepartmentTypeByName(req.getName());

        if (departmentType!=null){
            return ResponseEntity.badRequest().body("there is an this data");
        }
        departmentTypeRepo.save(new DepartmentType(req.getName()));
        return ResponseEntity.ok("succesfully");
    }
}
