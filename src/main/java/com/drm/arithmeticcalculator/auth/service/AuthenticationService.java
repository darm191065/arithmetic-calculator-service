package com.drm.arithmeticcalculator.auth.service;

import com.drm.arithmeticcalculator.auth.dto.LoginDto;
import com.drm.arithmeticcalculator.auth.model.AuthenticatedUser;

public interface AuthenticationService {

//    AuthResponseDto login(LoginDto loginDto);

    AuthenticatedUser userSignUp(LoginDto loginDto);

    AuthenticatedUser authenticate(LoginDto loginDto);

    AuthenticatedUser createAdmin(LoginDto loginDto);

    AuthenticatedUser creteSuperUser(LoginDto loginDto);
}
