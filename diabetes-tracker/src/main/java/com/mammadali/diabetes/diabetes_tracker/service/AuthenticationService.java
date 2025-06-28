package com.mammadali.diabetes.diabetes_tracker.service;

import com.mammadali.diabetes.diabetes_tracker.dao.entity.UserEntity;
import com.mammadali.diabetes.diabetes_tracker.dao.repository.UserRepository;

import com.mammadali.diabetes.diabetes_tracker.model.dto.request.LoginRequestDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.LoginResponseDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.request.UserRegisterRequestDto;
import com.mammadali.diabetes.diabetes_tracker.model.enums.Role;
import com.mammadali.diabetes.diabetes_tracker.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public LoginResponseDto login(LoginRequestDto request) {
        log.info("User login cəhdi: {}", request.getEmail());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        log.info("User {} uğurla daxil oldu", request.getEmail());

        String jwtToken = jwtService.generateToken(user);

        return LoginResponseDto.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();
    }


    public void register(UserRegisterRequestDto request) {
        boolean exists = userRepository.existsByEmail(request.getEmail());
        if (exists) {
            throw new IllegalStateException("Email artıq qeydiyyatdan keçib");
        }
        UserEntity user = UserEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .birthDate(request.getBirthDate())
                .role(Role.USER) // default olaraq USER veririk
                .build();

        userRepository.save(user);
    }
}