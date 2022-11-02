package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.payload.request.RegionRequest;
import org.springframework.http.ResponseEntity;

public interface RegionService {

    ResponseEntity<String> saveRegion(RegionRequest regionRequest);
}
