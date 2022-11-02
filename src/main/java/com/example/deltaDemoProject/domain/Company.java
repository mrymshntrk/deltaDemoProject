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
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Short_Name")
    private String shortName;
    @Column(name = "Address_Street")
    private String addressStreet;

    @JoinColumn(name = "Company_Type_ID", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private CompanyType companyType;

    @JoinColumn(name = "Address_Town", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Town town;

    public Company(String name, String shortName,
                   String addressStreet, CompanyType companyType, Town town) {

        this.name = name;
        this.shortName = shortName;
        this.addressStreet = addressStreet;
        this.companyType = companyType;
        this.town = town;
    }
}
