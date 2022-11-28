package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.dto.auth.AccountDTO;

public interface AuthService {
    AccountDTO login(AccountDTO accountDTO);
}
