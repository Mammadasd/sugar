package com.mammadali.diabetes.diabetes_tracker.controller;

import com.mammadali.diabetes.diabetes_tracker.model.dto.request.LoginRequestDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.LoginResponseDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.request.UserRegisterRequestDto;
import com.mammadali.diabetes.diabetes_tracker.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterRequestDto request) {
        authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Qeydiyyat uğurludur");
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto request) {
        LoginResponseDto response = authenticationService.login(request);
        return ResponseEntity.ok(response);
    }
}
