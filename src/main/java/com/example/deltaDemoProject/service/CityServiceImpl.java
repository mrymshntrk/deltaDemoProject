package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.City;
import com.example.deltaDemoProject.domain.ERole;
import com.example.deltaDemoProject.domain.User;
import com.example.deltaDemoProject.payload.request.CityRequest;
import com.example.deltaDemoProject.repo.CityRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CityServiceImpl implements CityService{

    private final CityRepo cityRepo;
    private  final UserService userService;

    @Override
    public ResponseEntity<String> saveCity(CityRequest req){

        User currentUser = userService.getCurrentUser();
        if(!userService.isCurrentUserHasRole(ERole.Admin)){
            return ResponseEntity.badRequest().body("Bu islemi yapmak icin yetkiniz yok.");
        }

        City city = cityRepo.findCityByName(req.getName());
        if (city!=null){
            return ResponseEntity.badRequest().body("there is an city already");

        }
        cityRepo.save(new City(req.getName()));
        return ResponseEntity.ok("başarıyla oluşturuldu");
    }

    public List<City> getCity(){
        return cityRepo.findAll();
    }



}
