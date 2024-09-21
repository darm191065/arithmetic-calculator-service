package com.drm.arithmeticcalculator.auth.model;

import com.drm.arithmeticcalculator.auth.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticatedUserRole {

    private long id;
    private RoleType role;
    private String description;
}
