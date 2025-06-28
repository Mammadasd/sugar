package com.mammadali.diabetes.diabetes_tracker.controller;

import com.mammadali.diabetes.diabetes_tracker.dao.entity.UserEntity;
import com.mammadali.diabetes.diabetes_tracker.model.dto.request.BloodSugarCreateRequestDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.BloodSugarResponseDto;
import com.mammadali.diabetes.diabetes_tracker.service.BloodSugarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-sugar")
@RequiredArgsConstructor
public class BloodSugarController {

    private final BloodSugarService bloodSugarService;

    @PostMapping
    public ResponseEntity<?> addEntry(@RequestBody @Valid BloodSugarCreateRequestDto dto,
                                      @AuthenticationPrincipal UserEntity user) {
        bloodSugarService.create(dto, user);
        return ResponseEntity.ok("Əlavə olundu");
    }

    @GetMapping
    public ResponseEntity<List<BloodSugarResponseDto>> getEntries(@AuthenticationPrincipal UserEntity user) {
        return ResponseEntity.ok(bloodSugarService.getAllByUser(user));
    }
}
