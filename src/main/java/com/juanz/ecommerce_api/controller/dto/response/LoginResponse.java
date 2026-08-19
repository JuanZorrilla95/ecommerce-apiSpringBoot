package com.juanz.ecommerce_api.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
// import lombok.Data;

@Getter
@Builder
public class LoginResponse {

    private String token;
}