package com.drm.arithmeticcalculator.auth.service;

import com.drm.arithmeticcalculator.auth.dto.AuthenticationRequestDto;
import com.drm.arithmeticcalculator.auth.dto.AuthenticationResponseDto;
import com.drm.arithmeticcalculator.auth.entity.UserPO;
import com.drm.arithmeticcalculator.auth.repo.UserRepository;
import com.drm.arithmeticcalculator.auth.token.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

//    private final UserMapper userMapper;

    private final JwtService jwtService;

    @Override
    public AuthenticationResponseDto login(AuthenticationRequestDto authenticationRequestDto) {
        UserPO user = this.userRepository.findByUsername(authenticationRequestDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                user, null, user.getAuthorities()
//        );
//
//        this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);


        String jwt = jwtService.generateToken(user, generateExtraClaims(user));
        AuthenticationResponseDto authenticationResponseDto = new AuthenticationResponseDto();
        authenticationResponseDto.setJwt(jwt);

        return authenticationResponseDto;
    }

    private Map<String, Object> generateExtraClaims(UserPO user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("role", user.getRole());
        extraClaims.put("permissions", user.getAuthorities());

        return extraClaims;
    }
}
