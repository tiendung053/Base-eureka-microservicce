package com.dailycodebuffer.user.service.impl;

import com.dailycodebuffer.user.dto.auth.AccountDTO;
import com.dailycodebuffer.user.dto.auth.LoginResponseDTO;
import com.dailycodebuffer.user.service.AuthService;
import org.apache.commons.codec.digest.Crypt;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AccountDTO login(AccountDTO accountDTO) {
        AccountDTO accountDTO1 = new AccountDTO();
        accountDTO1.setUsername(accountDTO.getUsername());
        accountDTO1.setPassword(accountDTO.getPassword());
        return accountDTO1;
    }
}
