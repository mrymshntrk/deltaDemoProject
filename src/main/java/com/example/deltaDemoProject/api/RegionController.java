package com.example.deltaDemoProject.api;


import com.example.deltaDemoProject.payload.request.RegionRequest;
import com.example.deltaDemoProject.service.RegionService;
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
public class RegionController {

    private RegionService regionService;

    @PostMapping("/region/save")
    public ResponseEntity<String> saveRegion(@Valid @RequestBody RegionRequest regionRequest){
        return regionService.saveRegion(regionRequest);
    }
}
