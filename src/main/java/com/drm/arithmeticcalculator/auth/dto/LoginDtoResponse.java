package com.drm.arithmeticcalculator.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDtoResponse {

    private String token;
    private Long expiration;
}
