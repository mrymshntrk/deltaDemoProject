package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.AppUser;
import com.example.deltaDemoProject.domain.Department;
import com.example.deltaDemoProject.domain.Role;
import com.example.deltaDemoProject.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final DepartmentRepo departmentRepo;

    @Override
    public AppUser saveUser(AppUser user) {

        return userRepo.save(user);
    }

    @Override
    public void addRoleToUser(String UserName, String roleName) {

        AppUser user = userRepo.findUserByEmail(UserName);
        Role role = roleRepo.findRoleByName(roleName);
        user.getRole().add(role);

    }

    @Override
    public void addDepartmentToUser(String UserName, String departmentName) {

        AppUser user = userRepo.findUserByEmail(UserName);
        Department department = departmentRepo.findDepartmentByName(departmentName);
        user.getDepartment().add(department);
    }

    @Override
    public AppUser getUser(String Email_Address) {

        return userRepo.findUserByEmail(Email_Address);
    }

    @Override
    public List<AppUser> getUser() {

        return userRepo.findAll();
        dhgdfjgjskdghdfk
    }
}
