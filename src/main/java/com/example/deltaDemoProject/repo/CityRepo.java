package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {

    City findCityByName (String name);

}
