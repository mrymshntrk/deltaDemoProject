package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.ERole;
import com.example.deltaDemoProject.domain.Role;
import com.example.deltaDemoProject.domain.User;
import com.example.deltaDemoProject.payload.request.RoleRequest;
import com.example.deltaDemoProject.repo.RoleRepo;
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
public class RoleServiceImpl implements RoleService{

    private final UserServiceImpl userServiceImpl;
    private final RoleRepo roleRepo;

    @Override
    public ResponseEntity<String> saveRole(RoleRequest req) {
        User currentUser = userServiceImpl.getCurrentUser();
        if(!userServiceImpl.isCurrentUserHasRole(ERole.Admin)){
            return ResponseEntity.badRequest().body("Bu islemi yapmak icin yetkiniz yok.");
        }

        Role role = roleRepo.findRoleByName(req.getName());
        if (role != null) {
            return ResponseEntity.badRequest().body("böyle bir role zaten var.");
        }

        roleRepo.save(new Role(req.getName()));
        return ResponseEntity.ok("role kaydedildi");
    }

    @Override
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(roleRepo.findAll());
    }

    // detayli aciklama yapmak zor
    /*public Role saveRole2(Role role) {
        try {
            return roleRepo.save(role);
        } catch (Exception e){
            return null;
        }
    }*/
}
