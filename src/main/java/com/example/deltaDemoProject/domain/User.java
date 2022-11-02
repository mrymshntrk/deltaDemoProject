package com.example.deltaDemoProject.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    //@Column(name = "name" ->"Name") -> gereksiz -> artik gerekli xd
    @Column(name = "Name")
    private String name;

    // private static final String SOME_STATIC_VARIABLE = "665165165"; -> convention ornek
    @Column(name = "Surname")
    private String surname;

    @Column(name = "Password")
    private String password;

    @Column(name = "Is_Active")
    private Boolean isActive;

    @Column(name = "Email_Address")
    private String emailAddress;

    @JoinColumn(name = "User_Role_ID", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    @JoinColumn(name = "Department_ID", insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    public User(String name, String surname, String password,
                Boolean isActive, String emailAddress,
                Role role, Department department) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.isActive = isActive;
        this.emailAddress = emailAddress;
        this.role = role;
        this.department = department;
    }
}

/*İD, SAVE, MODİFY, DELETE, GETALL */