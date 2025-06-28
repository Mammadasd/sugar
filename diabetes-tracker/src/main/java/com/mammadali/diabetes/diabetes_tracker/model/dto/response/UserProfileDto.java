package com.mammadali.diabetes.diabetes_tracker.model.dto.response;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileDto {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private LocalDate birthDate;

}
