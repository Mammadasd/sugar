package com.mammadali.diabetes.diabetes_tracker.model.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDto {

    private String email;

    private String password;
}
