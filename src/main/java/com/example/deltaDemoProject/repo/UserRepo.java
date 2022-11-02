package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findUserByEmailAddressAndRole_IdAndDepartment_Id(String email, Long userRoleId, Long departmentId); //findxxby(FieldName)

    User findUserByEmailAddress(String email);
}
