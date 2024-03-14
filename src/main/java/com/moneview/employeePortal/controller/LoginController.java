package com.moneview.employeePortal.controller;

import com.moneview.employeePortal.domain.dto.LoginRequestDto;
import com.moneview.employeePortal.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        if (loginService.authenticateUser(username, password)) {
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }
    }
}
