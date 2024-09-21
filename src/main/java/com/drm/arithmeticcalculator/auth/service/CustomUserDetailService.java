package com.drm.arithmeticcalculator.auth.service;

import com.drm.arithmeticcalculator.auth.mapper.UserMapper;
import com.drm.arithmeticcalculator.auth.model.AuthenticatedUser;
import com.drm.arithmeticcalculator.auth.model.AuthenticatedUserRole;
import com.drm.arithmeticcalculator.auth.repo.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .map(this.userMapper::fromEntityToModel)
                .map(this::buildUser)
                .orElseThrow(() -> new UsernameNotFoundException(username));

    }

    private User buildUser(AuthenticatedUser user) {
        return new User(user.getUsername(), user.getPassword(), getAuthority(user.getRoles()));
    }

    private List<SimpleGrantedAuthority> getAuthority(final Set<AuthenticatedUserRole> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().name()))
                .toList();
    }
}
