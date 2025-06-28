package com.mammadali.diabetes.diabetes_tracker.controller;


import com.mammadali.diabetes.diabetes_tracker.dao.entity.UserEntity;
import com.mammadali.diabetes.diabetes_tracker.model.dto.request.UserRegisterRequestDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.UserProfileDto;
import com.mammadali.diabetes.diabetes_tracker.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/my-profile")
    public ResponseEntity<UserProfileDto> getProfile(@AuthenticationPrincipal UserEntity user ) {
        return ResponseEntity.ok(userService.getProfile(user));
    }


}
