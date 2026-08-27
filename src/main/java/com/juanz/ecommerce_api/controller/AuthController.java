package com.juanz.ecommerce_api.controller;

import com.juanz.ecommerce_api.controller.dto.request.LoginRequest;
import com.juanz.ecommerce_api.controller.dto.response.LoginResponse;
import com.juanz.ecommerce_api.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(userService.login(request));
    }
}
