package com.springboot.universal.service;

import javax.validation.Valid;

import com.springboot.universal.co.EmployeeCo;
import com.springboot.universal.dao.EmployeeDao;
import com.springboot.universal.dto.ComparativeRelationAndValue;
import com.springboot.universal.dto.EmployeeDto;
import com.springboot.universal.dto.EntryItem;
import com.springboot.universal.dto.GenericSearchFilter;
import com.springboot.universal.entity.Employee;
import com.springboot.universal.utils.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MessageSource messageSource;

    @Override
//    @Cacheable(value = "employee", key = "#genericSearchFilter.toString() + #pageNumber + #pageSize")
    public EntryItem<EmployeeDto> getEmployee(GenericSearchFilter genericSearchFilter, Integer pageNumber, Integer pageSize) {
        Map<String, ComparativeRelationAndValue> searchParams = genericSearchFilter.getSearchParams();
        log.info("Fetching Employee as per following queries : {}", searchParams);
        List<EmployeeDto> employeeDtoList = new LinkedList<>();
        long start = System.currentTimeMillis();
//        EntryItem<Employee> employeeEntryItem = employeeDao.findByCriteriaFields(genericSearchFilter, pageNumber, pageSize);
//        log.info("Time taken to get employees from employeeService /  cache= {} ms", (System.currentTimeMillis() - start));
//        if (!CollectionUtils.isEmpty(employeeEntryItem.getItems())) {
//            employeeEntryItem.getItems().forEach(employee -> {
//                EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
//                employeeDtoList.add(employeeDto);
//            });
//        }
//        return new EntryItem<>(employeeEntryItem.getTotalItemsCount(), employeeDtoList);
        return null;
    }

    @Override
    public EmployeeDto saveEmployee(@Valid EmployeeCo employeeCo) {

        Employee employee = CommonUtil.convert(employeeCo, Employee.class);

        employee = employeeDao.save(employee);
        return CommonUtil.convert(employee, EmployeeDto.class);
    }

    @Override
    public Map<String, Map> updateEmployee(List<EmployeeCo> employeeCos) {
        return null;
    }

    @Override
    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeCo employeeCo) {
        return null;
    }

    @Override
    public Object doDeactivation(Long employeeId) {
        return null;
    }

}
