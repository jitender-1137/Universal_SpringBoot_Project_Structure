package com.springboot.universal.controller;

import javax.validation.Valid;

import com.springboot.universal.dto.EmployeeDto;
import com.springboot.universal.dto.ResponseDto;
import com.springboot.universal.dto.SuccessResponseDto;
import com.springboot.universal.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1")
@Slf4j
@Validated
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseDto addEmplyee(@RequestBody @Valid EmployeeDto employeeDto) {
        logger.info("Controller save employee start");
        EmployeeDto employeeDto2 = employeeService.saveEmployee(employeeDto);
        logger.info("Controller save employee stop");
        return new SuccessResponseDto(employeeDto2, "Employee add successfully");
    }
}
