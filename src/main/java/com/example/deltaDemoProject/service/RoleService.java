package com.example.deltaDemoProject.service;


import com.example.deltaDemoProject.domain.Role;
import com.example.deltaDemoProject.payload.request.RoleRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {


    ResponseEntity<String> saveRole(RoleRequest roleRequest);

    ResponseEntity<List<Role>> getRoles();
}
