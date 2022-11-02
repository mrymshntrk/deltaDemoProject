package com.example.deltaDemoProject.api;

import com.example.deltaDemoProject.domain.User;
import com.example.deltaDemoProject.repo.UserRepo;
import com.example.deltaDemoProject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthorizationController {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password){
        User user = userRepo.findUserByEmailAddress(email);
        if(user == null){
            return ResponseEntity.badRequest().body("Boyle bir kullanici yok.");
        } else if (!user.getIsActive()) {
            return ResponseEntity.badRequest().body("Hesabinizi aktiflestirmeniz gerekmekte.");
        }
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().body("Yanlis sifre.");
        }
        userService.getCurrentUser(); // will return null
        // access_token ve refresh_token'i bu kullanici icin olusturup donuceksin
        return null;
    }

}
