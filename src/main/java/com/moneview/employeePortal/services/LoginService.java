package com.moneview.employeePortal.services;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    boolean authenticateUser(String username, String password);
}
