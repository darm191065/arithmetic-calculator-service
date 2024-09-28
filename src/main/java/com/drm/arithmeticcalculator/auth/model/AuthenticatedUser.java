package com.drm.arithmeticcalculator.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUser {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private AuthenticatedUserRole role;
}
