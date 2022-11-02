package com.example.deltaDemoProject.payload.request;

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
public class CompanyRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String shortName;
    @NotBlank
    private String addressStreet;
    @NotNull
    private Long companyTypeId;
    @NotNull
    private Long townId;


}


