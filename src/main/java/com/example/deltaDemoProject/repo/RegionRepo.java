package com.example.deltaDemoProject.repo;


import com.example.deltaDemoProject.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepo extends JpaRepository<Region, Integer> {

    Region findRegionByName (String Name);
}
