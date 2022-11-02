package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.*;
import com.example.deltaDemoProject.payload.request.TownRequest;
import com.example.deltaDemoProject.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class TownServiceImpl implements TownService{

    private final RegionRepo regionRepo;
    private final TownRepo townRepo;
    private final CityRepo cityRepo;

    private final UserService userService;
    @Override
    public ResponseEntity<String> saveTown(TownRequest req) {

        User currentUser = userService.getCurrentUser();
        if(!userService.isCurrentUserHasRole(ERole.Admin)){
            return ResponseEntity.badRequest().body("Bu islemi yapmak icin yetkiniz yok.");
        }
        Region region = regionRepo.findById(req.getRegionId()).orElse(null);
        if(region == null) {
            return ResponseEntity.badRequest().body("Boyle bir region bulunmamakta.");
        }
        // girilen regionId database'de gercek bir region'a karsilik gelmekte

        City city = cityRepo.findById(req.getCityId()).orElse(null);
        if(city == null) {
            return ResponseEntity.badRequest().body("Boyle bir city bulunmamakta.");
        }
        // girilen cityId database'de gercek bir city'e karsilik gelmekte

        Town town = townRepo.findTownByNameAndRegion_IdAndCity_Id(req.getName(), region.getId(), city.getId());
        if(town != null){
            return ResponseEntity.badRequest().body("Girilen degerlere sahip bir town mevcut.");
        }
        // girilen degerler dogru ve bu degerlere sahip bir town yok

        townRepo.save(new Town(req.getName(), region, city));
        return ResponseEntity.ok("town basariyla yaratildi.");
    }



    /*@Override
    public void modifyTown(ModifyTownRequest modifyTownRequest){

    }*/

    /* OneId, Save, Modify, Delete, getAll */


    public List<Town> getTown() {

        return townRepo.findAll();
    }


}

/*
{
        "name":"Icmeler",
        "regionId":-5,
        "cityId": -6
        }
//expected result: bad request ->"Boyle bir region bulunmamakta."
        {
        "name":"Icmeler",
        "regionId":1,
        "cityId": -6
        }
//expected result: bad request ->"Boyle bir city bulunmamakta."
        {
        "name":"Icmeler",
        "regionId":1,
        "cityId": 2
        }
//expected result: ok -> basarili
        {
        "name":"Icmeler",
        "regionId":1,
        "cityId": 2
        }
//expected result: bad request -> "Girilen degerlere sahip bir town mevcut."

 */
