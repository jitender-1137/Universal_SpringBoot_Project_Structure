package com.springboot.universal.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto {

    private Long id;

    //    @NotBlank
    private String name;

    //    @NotBlank
    private String designation;

    private String createdAt;

    private String UpdatedAt;

    //    @NotBlank
    private String password;

}
