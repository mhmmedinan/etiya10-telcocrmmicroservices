package com.etiya.authservice.service.concretes;

import com.etiya.authservice.domain.User;
import com.etiya.authservice.repository.UserRepository;
import com.etiya.authservice.service.absracts.UserService;
import com.etiya.authservice.service.dtos.RegisterUserRequest;
import com.etiya.authservice.service.dtos.UserResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse add(RegisterUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        var createdUser = userRepository.save(user);
        UserResponse response = new UserResponse();
        response.setEmail(createdUser.getEmail());
        response.setFirstName(createdUser.getFirstName());
        response.setLastName(createdUser.getLastName());
        return response;


    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()->new AccessDeniedException("Giriş başarısız"));
    }
}
