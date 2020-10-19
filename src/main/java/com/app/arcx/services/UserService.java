package com.app.arcx.services;


import com.app.arcx.dto.LoginRequest;
import com.app.arcx.dto.LoginResponse;
import com.app.arcx.dto.UserSummary;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

public interface UserService {
    ResponseEntity<LoginResponse> login(@Valid LoginRequest loginRequest, String accessToken, String refreshToken);

    ResponseEntity<LoginResponse> refresh(String accessToken, String refreshToken);

    UserSummary getUserProfile();
}
