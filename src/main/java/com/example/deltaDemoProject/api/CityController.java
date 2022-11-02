package com.example.deltaDemoProject.api;


import com.example.deltaDemoProject.domain.City;
import com.example.deltaDemoProject.domain.ERole;
import com.example.deltaDemoProject.domain.User;
import com.example.deltaDemoProject.payload.request.CityRequest;
import com.example.deltaDemoProject.service.CityService;
import com.example.deltaDemoProject.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CityController {

    private CityService cityService;
    private UserServiceImpl userServiceImpl;

    @PostMapping("/city/save")
    public ResponseEntity<String> saveCity(@Valid @RequestBody CityRequest cityRequest){
        return cityService.saveCity(cityRequest);
    }

    @GetMapping("/city/show")
    //@PreAuthorize("hasRole('Admin')")
    public ResponseEntity<?> getAllCities(){
        User user = userServiceImpl.getCurrentUser();
        if(!userServiceImpl.isCurrentUserHasRole(ERole.Admin)){
            return ResponseEntity.badRequest().body("Kullanıcının bu işlemi yapmaya yetkisi yok.");
        }

        return cityService.getAllCities();
    }
}
