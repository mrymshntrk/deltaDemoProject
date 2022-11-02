package com.example.deltaDemoProject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor
@Table(name="user_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    /*public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }*/ //== @AllArgsConstructor , DONT_USE-> WHY:You can never assign id


    public Role(String name) {

        this.name = name;
    }
}

