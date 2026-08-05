package com.juanz.ecommerce_api.service.impl;

import com.juanz.ecommerce_api.dto.request.UserRequest;
import com.juanz.ecommerce_api.dto.response.UserResponse;
import com.juanz.ecommerce_api.entity.Role;
import com.juanz.ecommerce_api.entity.User;
import com.juanz.ecommerce_api.repository.UserRepository;
import com.juanz.ecommerce_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.juanz.ecommerce_api.exception.UserAlreadyExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository; //Spring inyecta automáticamente el repositorio

    @Override
    public UserResponse create(UserRequest request) {

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword()) // luego la encriptaremos
                .role(Role.CUSTOMER)
                .enabled(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        User savedUser = userRepository.save(user);
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(request.getEmail());
        }
        return UserResponse.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .build();
    }

    @Override
    public List<UserResponse> findAll() {

        return userRepository.findAll()
                .stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .build())
                .toList();
    }
}