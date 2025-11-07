package com.etiya.authservice.service.absracts;

import com.etiya.authservice.service.dtos.RegisterUserRequest;
import com.etiya.authservice.service.dtos.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserResponse add(RegisterUserRequest request);
}
