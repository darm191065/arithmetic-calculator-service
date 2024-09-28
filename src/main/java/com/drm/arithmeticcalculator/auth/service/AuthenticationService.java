package com.drm.arithmeticcalculator.auth.service;

import com.drm.arithmeticcalculator.auth.dto.AuthenticationRequestDto;
import com.drm.arithmeticcalculator.auth.dto.AuthenticationResponseDto;

public interface AuthenticationService {

    AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto);
}
