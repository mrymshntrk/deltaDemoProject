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
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private Integer Company_Type_ID;
    private Integer Address_Town;
    private String Name;
    private String Short_Name;
    private String Address_Street;

    @OneToMany(mappedBy = "company")
    private Set<CompanyType> companyTypes;

    @OneToMany(mappedBy = "company")
    private Set<Town> towns;
}
