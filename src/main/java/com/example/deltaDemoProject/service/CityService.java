package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.payload.request.CityRequest;
import org.springframework.http.ResponseEntity;

public interface CityService {

    ResponseEntity<String> saveCity(CityRequest cityRequest);
}
