package com.etiya.authservice.service.absracts;

import com.etiya.authservice.service.dtos.RegisterUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void add(RegisterUserRequest request);
}
