package com.example.deltaDemoProject.api;


import com.example.deltaDemoProject.payload.request.CityRequest;
import com.example.deltaDemoProject.service.CityService;
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
public class CityController {

    private CityService cityService;

    @PostMapping("/city/save")
    public ResponseEntity<String> saveCity(@Valid @RequestBody CityRequest cityRequest){
        return cityService.saveCity(cityRequest);
    }
}
