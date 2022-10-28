package com.springboot.universal.service;

import javax.validation.Valid;

import com.springboot.universal.dto.EmployeeDto;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeDto saveEmployee(@Valid EmployeeDto employeeDto) {
        // TODO Auto-generated method stub
        return null;
    }

}
