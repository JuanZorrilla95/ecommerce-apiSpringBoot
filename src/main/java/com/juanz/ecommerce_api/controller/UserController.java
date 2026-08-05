package com.juanz.ecommerce_api.controller;

import com.juanz.ecommerce_api.dto.request.UserRequest;
import com.juanz.ecommerce_api.dto.response.UserResponse;
import com.juanz.ecommerce_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Le dice a Spring que esta clase expone endpoints REST y que las respuestas serán JSON.
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody UserRequest request) {

        UserResponse response = userService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {

        return ResponseEntity.ok(userService.findAll());
    }
}