package com.example.deltaDemoProject.api;

import com.example.deltaDemoProject.payload.request.TownRequest;
import com.example.deltaDemoProject.service.TownService;
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
public class TownController {
    private TownService townService;

    @PostMapping("/town/save")
    public ResponseEntity<String> saveTown(@Valid @RequestBody TownRequest townRequest){
       return townService.saveTown(townRequest);
    }
}

