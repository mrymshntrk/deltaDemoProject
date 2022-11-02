package com.example.deltaDemoProject.utility;

import com.auth0.jwt.JWT;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.stream.Collectors;

public class JwtUtil {

    public static String createAccessToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256("secret");

        String access_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 15L * 60 * 1000))
                .withIssuer("api/auth/login")
                .withClaim("user_roles",
                        user.getAuthorities().stream().map(GrantedAuthority:: getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
        return access_token;
    }
}
