package com.springboot.universal.service;

import javax.validation.Valid;

import com.springboot.universal.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(@Valid EmployeeDto employeeDto);

}
