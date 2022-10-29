package com.springboot.universal.dao;

import com.springboot.universal.dto.EntryItem;
import com.springboot.universal.dto.GenericSearchFilter;
import com.springboot.universal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

    Employee findByUserName(String username);

//    EntryItem<Employee> findByCriteriaFields(GenericSearchFilter genericSearchFilter, Integer pageNumber, Integer pageSize);
}
