package com.example.deltaDemoProject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="town")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Name;
    private Integer Region_ID;
    private Integer City_ID;

    @OneToMany(mappedBy = "town")
    private Set<Region> regions;

    @OneToMany(mappedBy = "town")
    private Set<City> cities;
}
