package com.zw.jimfish.domain.enums.auth;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;
    private String password;
}
