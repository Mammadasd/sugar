package com.mammadali.diabetes.diabetes_tracker.controller;


import com.mammadali.diabetes.diabetes_tracker.model.dto.response.AdminUserDetailDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.UserProfileDto;
import com.mammadali.diabetes.diabetes_tracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserProfileDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<AdminUserDetailDto> getUserDetail(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserDetail(id));
    }

}
