package com.example.deltaDemoProject.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class RoleRequest {
    @NotBlank
    private String name;
}

/*
{
    "name":"deger"
}
 */