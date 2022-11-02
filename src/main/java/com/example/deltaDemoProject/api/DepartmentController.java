package com.example.deltaDemoProject.api;

import com.example.deltaDemoProject.payload.request.DepartmentRequest;
import com.example.deltaDemoProject.service.DepartmentService;
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
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("/department/save")
    public ResponseEntity<String> saveDepartment(@Valid @RequestBody DepartmentRequest departmentRequest){
        return departmentService.saveDepartment(departmentRequest);
    }
}


