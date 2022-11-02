package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.ERole;
import com.example.deltaDemoProject.domain.User;
import com.example.deltaDemoProject.domain.Department;
import com.example.deltaDemoProject.domain.Role;
import com.example.deltaDemoProject.payload.request.UserRequest;
import com.example.deltaDemoProject.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;


@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserDetailsService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final DepartmentRepo departmentRepo;
    private final BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByEmailAddress(username);
        if (user == null) {
            log.error("user not found!");
            throw new UsernameNotFoundException("user not found");
        } else {
            log.info("user found: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities =
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()));
        return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(), authorities);

    }

    public ResponseEntity<String> saveUser(UserRequest req){

        if(!isCurrentUserHasRole(ERole.Admin)){
            return ResponseEntity.badRequest().body("Bu islemi yapmak icin yetkiniz yok.");
        }

        Role role = roleRepo.findById(req.getUserRoleId()).orElse(null);
        if (role == null) {
            return ResponseEntity.badRequest().body("böyle bir role yok");
        }
        Department department=departmentRepo.findById(req.getDepartmentId()).orElse(null);
        if (department == null) {
            return ResponseEntity.badRequest().body("böyle bir department yok");
        }
        User user=userRepo.findUserByEmailAddressAndRole_IdAndDepartment_Id(req.getName(), role.getId(),department.getId());
        if (user != null) {
            return ResponseEntity.badRequest().body("böyle bir user zaten var");
        }
        userRepo.save(new User(req.getName(), req.getSurname(),
                encoder.encode(req.getPassword()), req.getIsActive(),
                req.getEmailAddress(), role, department));
        return ResponseEntity.ok("user başarıyla kaydedildi");
    }


    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null){
            return null;
        }
        String email = authentication.getName();
        return userRepo.findUserByEmailAddress(email);
    }

    public boolean isCurrentUserHasRole(ERole role){
        User user = getCurrentUser();
        return user.getRole().getName().equals(role.name());
    }
}

