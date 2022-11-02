package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.ERole;
import com.example.deltaDemoProject.domain.User;
import com.example.deltaDemoProject.payload.request.UserRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {

    ResponseEntity<String> saveUser(UserRequest userRequest);
    User getCurrentUser();
    public boolean isCurrentUserHasRole(ERole role);
}
