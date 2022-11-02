package com.example.deltaDemoProject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="town")
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Name")
    private String name;

    @JoinColumn(name = "Region_ID", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Region region;

    @JoinColumn(name = "City_ID", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private City city;

    public Town(String name, Region region, City city) {
        this.name = name;
        this.region = region;
        this.city = city;
    }
}
