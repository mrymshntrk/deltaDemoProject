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
public class DepartmentRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String addressStreet;
    @NotNull
    private Long companyId;
    @NotNull
    private Long departmentTypeId;
    @NotNull
    private Long townId;
}
