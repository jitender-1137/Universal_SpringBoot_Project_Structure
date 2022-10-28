package com.springboot.universal.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String designation;

    private String createdAt;

    private String UpdatedAt;

    @NotBlank
    private String password;

}
