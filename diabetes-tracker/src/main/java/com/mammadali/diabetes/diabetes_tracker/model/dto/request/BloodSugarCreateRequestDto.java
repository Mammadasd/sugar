package com.mammadali.diabetes.diabetes_tracker.model.dto.request;

import com.mammadali.diabetes.diabetes_tracker.model.enums.MeasurementType;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodSugarCreateRequestDto {

    private LocalDate date;

    @NotNull
    private Double level;

    @NotNull
    private MeasurementType type;
}
