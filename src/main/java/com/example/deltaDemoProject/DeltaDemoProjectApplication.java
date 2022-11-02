package com.example.deltaDemoProject;

import com.example.deltaDemoProject.domain.*;
import com.example.deltaDemoProject.payload.request.RoleRequest;
import com.example.deltaDemoProject.payload.request.TownRequest;
import com.example.deltaDemoProject.repo.CityRepo;
import com.example.deltaDemoProject.repo.RegionRepo;
import com.example.deltaDemoProject.repo.RoleRepo;
import com.example.deltaDemoProject.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DeltaDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeltaDemoProjectApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Bean
	CommandLineRunner setUpData(RoleService roleService,
								TownService townService,
								CityRepo cityRepo, RegionRepo regionRepo){
		return args -> {

			roleService.saveRole(new RoleRequest("Admin "));
			roleService.saveRole(new RoleRequest("Manager"));

			townService.saveTown(new TownRequest("içmeler", 1L, 1L));

		};
	}

}
