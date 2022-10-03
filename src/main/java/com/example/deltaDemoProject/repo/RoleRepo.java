package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    Role findRoleByName(String Name);
}
