package com.drm.arithmeticcalculator.controller;

import com.drm.arithmeticcalculator.auth.dto.AuthenticationRequestDto;
import com.drm.arithmeticcalculator.auth.dto.AuthenticationResponseDto;
import com.drm.arithmeticcalculator.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PreAuthorize("permitAll()")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthenticationRequestDto requestDto) {

        return ResponseEntity.ok(this.authenticationService.login(requestDto));
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/public-access")
    public String publicEndpoint(){
        return "public-access";
    }
}
