package com.springboot.universal.controller;

import javax.validation.Valid;

import com.springboot.universal.co.EmployeeCo;
import com.springboot.universal.dto.*;
import com.springboot.universal.exceptions.ServiceException;
import com.springboot.universal.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/search")
    public ResponseDto getAllEmployee(@RequestBody GenericSearchFilter genericSearchFilter,
                                      @RequestParam(required = false) Integer pageNumber,
                                      @RequestParam(required = false) Integer pageSize) {

        EntryItem<EmployeeDto> employeeDtosEntryItem =
                employeeService.getEmployee(genericSearchFilter, pageNumber, pageSize);
        return new SuccessResponseDto(employeeDtosEntryItem.getItems(), "Employee Successfully fetched", employeeDtosEntryItem.getTotalItemsCount());
    }


    @PostMapping("/add")
    public ResponseDto addEmplyee(@RequestBody @Valid EmployeeCo employeeCo) {
        logger.info("Controller save employee start");
        EmployeeDto employeeDto2 = employeeService.saveEmployee(employeeCo);
        logger.info("Controller save employee stop");
        return new SuccessResponseDto(employeeDto2, "Employee add successfully");
    }

    @PutMapping
//	@Secured("ROLE_APPROVE_CATEGORY")
    public ResponseDto updateEmployee(@RequestBody List<EmployeeCo> employeeCos) {
        if (CollectionUtils.isEmpty(employeeCos))
            throw new ServiceException("CS_02");
        Map<String, Map> updateResult = employeeService.updateEmployee(employeeCos);
        return new SuccessResponseDto(updateResult, "Details of updates in response data");
    }

    @PutMapping("/{id}")
//	@Secured("ROLE_EDIT_CATEGORY")
    public ResponseDto update(@PathVariable("id") Long employeeId, @RequestBody @Valid EmployeeCo employeeCo) {
        EmployeeDto updateCategory = employeeService.updateEmployeeById(employeeId, employeeCo);
        return new SuccessResponseDto(updateCategory, "Details of updates in response data");
    }

    @DeleteMapping("/{category-id}")
//	@Secured("ROLE_DELETE_CATEGORY")
    public ResponseDto softDeleteCategory(@PathVariable("category-id") Long employeeId) {
        if (employeeId == null || employeeId == 0)
            throw new ServiceException("CS_03");
        return new SuccessResponseDto(employeeService.doDeactivation(employeeId), "Category Successfully Soft Deleted");
    }
}
