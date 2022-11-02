package com.example.deltaDemoProject.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @JsonIgnore
    private String password;
    /////
    private Boolean isActive;
    @NotBlank
    private String emailAddress;
    @NotNull
    private Long userRoleId;
    @NotNull
    private Long departmentId;

}
