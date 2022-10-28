package com.springboot.universal.service;

import javax.validation.Valid;

import com.springboot.universal.co.EmployeeCo;
import com.springboot.universal.dto.EmployeeDto;
import com.springboot.universal.dto.EntryItem;
import com.springboot.universal.dto.GenericSearchFilter;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    EmployeeDto saveEmployee(@Valid EmployeeCo employeeCo);

    EntryItem<EmployeeDto> getEmployee(GenericSearchFilter genericSearchFilter, Integer pageNumber, Integer pageSize);

    Map<String, Map> updateEmployee(List<EmployeeCo> employeeCos);

    EmployeeDto updateEmployeeById(Long employeeId, EmployeeCo employeeCo);

    Object doDeactivation(Long employeeId);

}
