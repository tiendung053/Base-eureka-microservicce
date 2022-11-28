package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.dto.auth.AccountDTO;
import com.dailycodebuffer.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "login")
    public AccountDTO login(AccountDTO accountDTO) {
        return authService.login(accountDTO);
    }

    @GetMapping(value = "info")
    public String getInfo() {
        return "Ngu di anh";
    }
}
