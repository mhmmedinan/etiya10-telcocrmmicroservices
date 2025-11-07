package com.etiya.authservice.controller;

import com.etiya.authservice.service.absracts.AuthService;
import com.etiya.authservice.service.dtos.LoggedResponse;
import com.etiya.authservice.service.dtos.LoginRequest;
import com.etiya.authservice.service.dtos.RegisterResponse;
import com.etiya.authservice.service.dtos.RegisterUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@RequestBody RegisterUserRequest request){
       return authService.register(request);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public LoggedResponse login(@RequestBody LoginRequest request){
        return authService.login(request);
    }
}
