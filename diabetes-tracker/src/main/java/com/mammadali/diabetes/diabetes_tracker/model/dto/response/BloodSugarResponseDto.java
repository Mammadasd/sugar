package com.mammadali.diabetes.diabetes_tracker.model.dto.response;

import com.mammadali.diabetes.diabetes_tracker.model.enums.MeasurementType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodSugarResponseDto {
    private Long id;
    private LocalDate date;
    private Double level;
    private MeasurementType type;
    private LocalDateTime createdAt;
}
