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

@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Name")
    private String name;

    @Column(name = "Address_Street")
    private String addressStreet;

    @JoinColumn(name = "Company_ID", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    @JoinColumn(name = "Department_Type_ID", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private DepartmentType departmentType;

    @JoinColumn(name = "Address_Town", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Town town;

    public Department(String name,
                      String addressStreet, Company company,
                      DepartmentType departmentType, Town town) {
        this.name = name;
        this.addressStreet = addressStreet;
        this.company = company;
        this.departmentType = departmentType;
        this.town = town;
    }
}

