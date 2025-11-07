package com.etiya.authservice.service.concretes;

import com.etiya.authservice.service.absracts.AuthService;
import com.etiya.authservice.service.absracts.UserService;
import com.etiya.authservice.service.dtos.LoggedResponse;
import com.etiya.authservice.service.dtos.LoginRequest;
import com.etiya.authservice.service.dtos.RegisterResponse;
import com.etiya.authservice.service.dtos.RegisterUserRequest;
import com.etiya.common.crosscuttingconcerns.exceptions.types.BusinessException;
import com.etiya.common.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtService jwtService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(JwtService jwtService, UserService userService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public RegisterResponse register(RegisterUserRequest request) {
       var user = userService.add(request);
       RegisterResponse response = new RegisterResponse();
        response.setEmail(user.getEmail());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        return response;
        //Register işlemi için business kuralları tanımlayın
    }

    @Override
    public LoggedResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        if(!authentication.isAuthenticated())
            throw new BusinessException("E posta veya şifre hatalı"); //RuntimeEx türü AuthenticationEx olacak.

        UserDetails user = userService.loadUserByUsername(request.getEmail());

        String token = jwtService.generateToken(user.getUsername(),user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());

        String expiration = jwtService.extractExpiration(token).toString();
        return new LoggedResponse(token,expiration);
    }
}
