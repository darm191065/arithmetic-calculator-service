package com.drm.arithmeticcalculator.auth.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

import static com.drm.arithmeticcalculator.auth.entity.enums.Permission.*;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER(Set.of(USER_WRITE, USER_READ)),
    ADMIN(Set.of(ADMIN_WRITE, ADMIN_READ, USER_WRITE, USER_READ )),
    MANAGER(Set.of(MANAGER_READ, MANAGER_WRITE, ADMIN_WRITE, ADMIN_READ, USER_WRITE, USER_READ));

    private final Set<Permission> permissions;

}
