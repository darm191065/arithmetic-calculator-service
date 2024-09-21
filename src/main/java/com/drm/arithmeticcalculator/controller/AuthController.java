package com.drm.arithmeticcalculator.controller;

import com.drm.arithmeticcalculator.auth.dto.LoginDto;
import com.drm.arithmeticcalculator.auth.dto.LoginDtoResponse;
import com.drm.arithmeticcalculator.auth.model.AuthenticatedUser;
import com.drm.arithmeticcalculator.auth.model.CustomUserDetails;
import com.drm.arithmeticcalculator.auth.service.AuthenticationService;
import com.drm.arithmeticcalculator.auth.token.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginDtoResponse> login(@RequestBody LoginDto loginDto) {
        // todo mover esto al servicio
        AuthenticatedUser user = this.authenticationService.authenticate(loginDto);
        //todo add mapper
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        String token = this.jwtService.generateToken(customUserDetails);

        return ResponseEntity.ok(LoginDtoResponse.builder()
                        .token(token)
                        .expiration(this.jwtService.getJwtExpiration())
                .build());
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthenticatedUser> signUp(@RequestBody LoginDto loginDto) {
        AuthenticatedUser authenticatedUser = this.authenticationService.userSignUp(loginDto);

        return ResponseEntity.ok(authenticatedUser);
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<AuthenticatedUser> createAdmin(@RequestBody LoginDto loginDto) {
        AuthenticatedUser authenticatedUser = this.authenticationService.createAdmin(loginDto);

        return ResponseEntity.ok(authenticatedUser);
    }

    @PostMapping("/createSuperUser")
    public ResponseEntity<AuthenticatedUser> createSuperUser(@RequestBody LoginDto loginDto) {
        AuthenticatedUser authenticatedUser = this.authenticationService.creteSuperUser(loginDto);

        return ResponseEntity.ok(authenticatedUser);
    }
}
