package com.example.deltaDemoProject.repo;


import com.example.deltaDemoProject.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<Region, Long> {

    Region findRegionByName (String name);
}
