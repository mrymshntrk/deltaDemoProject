package com.example.deltaDemoProject.service;

import com.example.deltaDemoProject.domain.Town;

public interface TownService {

    Town saveTown(Town town);

    void addRegionToTown(String townName, String regionName);
    void addCityToTown(String townName, String cityName);
}
