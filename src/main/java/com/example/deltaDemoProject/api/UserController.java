package com.example.deltaDemoProject.api;

import com.example.deltaDemoProject.payload.request.UserRequest;
import com.example.deltaDemoProject.service.UserServiceImpl;
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
public class UserController {

    private UserServiceImpl userServiceImpl;

    @PostMapping("/user/save")
    public ResponseEntity<String> saveUser(@Valid @RequestBody UserRequest userRequest){
        return userServiceImpl.saveUser(userRequest);
    }
}
