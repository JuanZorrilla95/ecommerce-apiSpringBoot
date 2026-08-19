package com.juanz.ecommerce_api.service;

import com.juanz.ecommerce_api.controller.dto.request.UserRequest;
import com.juanz.ecommerce_api.controller.dto.response.UserResponse;
import com.juanz.ecommerce_api.controller.dto.request.LoginRequest;
import com.juanz.ecommerce_api.controller.dto.response.LoginResponse;
import com.juanz.ecommerce_api.controller.dto.request.ChangePasswordRequest;

import java.util.List;

public interface UserService {

    UserResponse create(UserRequest request);
    UserResponse findById(Long id);
    UserResponse update(Long id, UserRequest request);
	void delete(Long id);
	void changePassword(Long id, ChangePasswordRequest request);
    
    LoginResponse login(LoginRequest request);
    
    List<UserResponse> findAll();
}