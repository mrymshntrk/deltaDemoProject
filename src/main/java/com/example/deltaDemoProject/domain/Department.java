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
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String Name;
    private Integer Company_ID;
    private Integer Department_Type_ID ;
    private Integer Address_Town;
    private String Address_Street;

    @OneToMany(mappedBy = "deparment")
    private Set<DepartmentType> departmentTypes;

    @OneToMany(mappedBy = "departmen")
    private Set<Company> companies;

    @OneToMany(mappedBy = "department")
    private Set<Town> towns;

}

