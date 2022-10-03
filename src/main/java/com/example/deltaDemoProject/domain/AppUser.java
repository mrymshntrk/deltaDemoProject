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
@AllArgsConstructor
@Table(name="user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer ID;
    private Integer User_Role_ID;
    private Integer Department_ID;
    private String Name;
    private String Surname;
    private String UserName;
    private String Password;
    private Boolean Is_Active;
    private String Email_Address;

    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    private Department department;
}
