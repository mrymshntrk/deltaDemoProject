package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.ERole;
import com.example.deltaDemoProject.domain.Region;
import com.example.deltaDemoProject.domain.User;
import com.example.deltaDemoProject.payload.request.RegionRequest;
import com.example.deltaDemoProject.repo.RegionRepo;
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
public class RegionServiceImpl implements RegionService{

    private final RegionRepo regionRepo;
    private final UserService userService;
    @Override
    public ResponseEntity<String> saveRegion(RegionRequest req){

        User currentUser = userService.getCurrentUser();
        if(!userService.isCurrentUserHasRole(ERole.Admin)){
            return ResponseEntity.badRequest().body("Bu islemi yapmak icin yetkiniz yok.");
        }
        Region region = regionRepo.findRegionByName(req.getName());
        if (region!=null){
            return ResponseEntity.badRequest().body("there is an this data");
        }
        regionRepo.save(new Region(req.getName()));
        return ResponseEntity.ok("successfully");
    }
    public List<Region> getRegion(){
        return regionRepo.findAll();
    }

}
