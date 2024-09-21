package com.drm.arithmeticcalculator.auth.service;

import com.drm.arithmeticcalculator.auth.dto.LoginDto;
import com.drm.arithmeticcalculator.auth.entity.RolePO;
import com.drm.arithmeticcalculator.auth.entity.UserPO;
import com.drm.arithmeticcalculator.auth.entity.enums.RoleType;
import com.drm.arithmeticcalculator.auth.mapper.UserMapper;
import com.drm.arithmeticcalculator.auth.model.AuthenticatedUser;
import com.drm.arithmeticcalculator.auth.repo.RoleRepository;
import com.drm.arithmeticcalculator.auth.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    @Override
    public AuthenticatedUser userSignUp(LoginDto loginDto) {

        Optional<RolePO> optionalUserRole = this.roleRepository.findByName(RoleType.USER);

        UserPO userPO = UserPO.builder()
                .username(loginDto.getUsername())
                .email(loginDto.getEmail())
                .password(this.passwordEncoder.encode(loginDto.getPassword()))
                .roles(optionalUserRole.map(Set::of).orElseThrow())
                .build();

        return this.userMapper.fromEntityToModel(userRepository.save(userPO));
    }

    @Override
    public AuthenticatedUser authenticate(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );

        return this.userRepository.findByUsername(loginDto.getUsername())
                .map(this.userMapper::fromEntityToModel)
                .orElseThrow();
    }

    @Override
    public AuthenticatedUser createAdmin(LoginDto loginDto) {
        Optional<RolePO> optionalUserRole = this.roleRepository.findByName(RoleType.ADMIN);

        UserPO userPO = UserPO.builder()
                .username(loginDto.getUsername())
                .email(loginDto.getEmail())
                .password(this.passwordEncoder.encode(loginDto.getPassword()))
                .roles(optionalUserRole.map(Set::of).orElseThrow())
                .build();

        return this.userMapper.fromEntityToModel(userRepository.save(userPO));
    }

    @Override
    public AuthenticatedUser creteSuperUser(LoginDto loginDto) {
        Optional<RolePO> optionalUserRole = this.roleRepository.findByName(RoleType.SUPER_USER);

        UserPO userPO = UserPO.builder()
                .username(loginDto.getUsername())
                .email(loginDto.getEmail())
                .password(this.passwordEncoder.encode(loginDto.getPassword()))
                .roles(optionalUserRole.map(Set::of).orElseThrow())
                .build();

        return this.userMapper.fromEntityToModel(userRepository.save(userPO));
    }
}
