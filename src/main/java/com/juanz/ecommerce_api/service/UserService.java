package com.juanz.ecommerce_api.service;

import com.juanz.ecommerce_api.controller.dto.request.UserRequest;
import com.juanz.ecommerce_api.controller.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse create(UserRequest request);
    UserResponse findById(Long id);
    UserResponse update(Long id, UserRequest request);
	void delete(Long id);

    List<UserResponse> findAll();
}