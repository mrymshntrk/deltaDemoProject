package com.example.deltaDemoProject.api;

import com.example.deltaDemoProject.domain.Role;
import com.example.deltaDemoProject.payload.request.RoleRequest;
import com.example.deltaDemoProject.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RoleController {


    private RoleService roleService;

    @PostMapping("/role/save")
    public ResponseEntity<String> saveRole(@Valid @RequestBody RoleRequest roleRequest){

        return roleService.saveRole(roleRequest);
    }

    @GetMapping("/role/show")
    //GetMapping'te request body kullanamazsin
    public ResponseEntity<List<Role>> getRoles(){
        roleService.saveRole(new RoleRequest("ahmet"));
        return roleService.getRoles();
    }
}
