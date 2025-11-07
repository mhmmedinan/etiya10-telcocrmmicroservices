package com.etiya.authservice.service.absracts;

import com.etiya.authservice.service.dtos.LoggedResponse;
import com.etiya.authservice.service.dtos.LoginRequest;
import com.etiya.authservice.service.dtos.RegisterResponse;
import com.etiya.authservice.service.dtos.RegisterUserRequest;

public interface AuthService {
    RegisterResponse register(RegisterUserRequest request);
    LoggedResponse login(LoginRequest request);
}
