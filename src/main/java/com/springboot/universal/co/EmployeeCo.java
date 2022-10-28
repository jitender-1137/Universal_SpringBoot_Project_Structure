package com.springboot.universal.co;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeCo {

    @NotBlank
    private String name;

    @NotBlank
    private String designation;

    @CreationTimestamp
    private String createdAt;

    @UpdateTimestamp
    private String UpdatedAt;

    @NotBlank
    private String password;

}
