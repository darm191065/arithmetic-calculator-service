package com.drm.arithmeticcalculator.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PreAuthorize("hasAnyAuthority('ADMIN_READ', 'USER_READ', 'MANAGER_READ')")
    @GetMapping
    public String get() {
        return "Hello World!";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN_READ', 'USER_READ', 'MANAGER_READ')")
    @PostMapping
    public String post(){
        return "Hello World!";
    }
}
