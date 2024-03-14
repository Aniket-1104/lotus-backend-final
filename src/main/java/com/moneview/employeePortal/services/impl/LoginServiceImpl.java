package com.moneview.employeePortal.services.impl;

import com.moneview.employeePortal.domain.entities.EmployeeEntity;
import com.moneview.employeePortal.repositories.EmployeeRepository;
import com.moneview.employeePortal.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean authenticateUser(String username, String password) {
        EmployeeEntity employee = employeeRepository.findByUsername(username);

        return employee != null && employee.getPassword().equals(password);
    }
}
