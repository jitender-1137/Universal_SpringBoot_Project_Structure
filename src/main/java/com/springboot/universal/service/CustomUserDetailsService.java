package com.springboot.universal.service;

import com.springboot.universal.dao.EmployeeDao;
import com.springboot.universal.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private EmployeeDao repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(employee.getUserName(), employee.getPassword(), new ArrayList<>());
    }
}
