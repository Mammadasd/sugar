package com.mammadali.diabetes.diabetes_tracker.model.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
        private String token;
        private long expiresIn;
}
