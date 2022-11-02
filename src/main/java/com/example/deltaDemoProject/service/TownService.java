package com.example.deltaDemoProject.service;


import com.example.deltaDemoProject.payload.request.TownRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TownService {

    ResponseEntity<String> saveTown(TownRequest townRequest);

}
