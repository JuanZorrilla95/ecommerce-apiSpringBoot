package com.juanz.ecommerce_api.service;

import com.juanz.ecommerce_api.dto.request.UserRequest;
import com.juanz.ecommerce_api.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse create(UserRequest request);

    List<UserResponse> findAll();
}