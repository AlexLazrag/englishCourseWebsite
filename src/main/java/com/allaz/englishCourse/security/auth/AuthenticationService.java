package com.allaz.englishCourse.security.auth;

import com.allaz.englishCourse.dto.security.AuthResponse;
import com.allaz.englishCourse.dto.security.LoginRequest;
import com.allaz.englishCourse.dto.user.UserRequest;
import com.allaz.englishCourse.entity.user.User;
import com.allaz.englishCourse.entity.user.UserRole;
import com.allaz.englishCourse.repository.user.UserRepository;
import com.allaz.englishCourse.repository.user.UserRoleRepository;
import com.allaz.englishCourse.security.config.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager manager;
    private final UserRoleRepository userRoleRepository;

    public AuthResponse register(UserRequest request){

        UserRole role = userRoleRepository.findById(2L).orElseThrow();


        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .userRole(role)
                .build();
        repository.save(user);
        var jwtToken = jwtUtil.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse login (LoginRequest request){
        manager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        var user = repository.findByEmail(request.getEmail()).orElseThrow(
                ()-> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtUtil.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
