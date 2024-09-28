package com.drm.arithmeticcalculator.auth.model;

import com.drm.arithmeticcalculator.auth.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUserRole {

    private long id;
    private Role role;
    private String description;
}
