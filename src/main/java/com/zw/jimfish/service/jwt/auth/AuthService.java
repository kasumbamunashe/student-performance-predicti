package com.zw.jimfish.service.jwt.auth;

import com.zw.jimfish.domain.enums.user.SignupRequest;
import com.zw.jimfish.domain.enums.user.UserDto;


public interface AuthService {


    UserDto signupUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
