package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.City;
import com.example.deltaDemoProject.domain.Region;
import com.example.deltaDemoProject.domain.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepo extends JpaRepository<Town, Long> {

        Town findTownByNameAndRegion_IdAndCity_Id(String name, Long regionId, Long cityId);
}
