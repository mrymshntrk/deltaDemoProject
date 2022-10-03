package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Integer> {

    AppUser findUserByEmail(String Email_Address);

}
