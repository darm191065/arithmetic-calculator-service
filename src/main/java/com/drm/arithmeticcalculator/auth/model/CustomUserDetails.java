package com.drm.arithmeticcalculator.auth.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    public static final String ROLE_PREFIX = "ROLE_";
    private final AuthenticatedUser authenticatedUser;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authenticatedUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(ROLE_PREFIX + role))
                .toList();
//        return List.of();
    }

    @Override
    public String getPassword() {
        return this.authenticatedUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.authenticatedUser.getUsername();
    }
}
