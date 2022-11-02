package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.City;
import com.example.deltaDemoProject.payload.request.CityRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityService {

    ResponseEntity<String> saveCity(CityRequest cityRequest);

    ResponseEntity<List<City>> getAllCities();
}
