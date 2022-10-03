package com.example.deltaDemoProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepo extends JpaRepository<TownRepo, Integer> {

        TownRepo findTownByName(String Name);
}
