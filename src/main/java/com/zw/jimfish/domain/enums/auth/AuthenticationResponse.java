package com.zw.jimfish.domain.enums.auth;

import com.zw.jimfish.domain.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;
    private long userId;
    private UserRole userRole;
    private boolean success;
    private String message;
}
