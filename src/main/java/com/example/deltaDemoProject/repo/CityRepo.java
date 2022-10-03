package com.example.deltaDemoProject.repo;

import com.example.deltaDemoProject.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> {

    City findCityByName (String Name);
}
