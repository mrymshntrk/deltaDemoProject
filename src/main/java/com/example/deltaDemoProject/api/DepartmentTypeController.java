package com.example.deltaDemoProject.api;

import com.example.deltaDemoProject.payload.request.DepartmentTypeRequest;
import com.example.deltaDemoProject.service.DepartmentTypeService;
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
public class DepartmentTypeController {

    private final DepartmentTypeService departmentTypeService;

    @PostMapping("/departmentType/save")

    public ResponseEntity<String> saveDepartmentType(@Valid @RequestBody DepartmentTypeRequest departmentTypeRequest){
        return departmentTypeService.saveDepartmentType(departmentTypeRequest);
    }


}
