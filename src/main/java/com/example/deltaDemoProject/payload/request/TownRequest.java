package com.example.deltaDemoProject.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TownRequest {
    @NotBlank
    private String name;
    @NotNull
    private Long regionId;
    @NotNull
    private Long cityId;
}
