package com.dailycodebuffer.user.dto.auth;

import lombok.Data;

@Data
public class AccountDTO {
    private Long userId;
    private String username;
    private String password;
}
