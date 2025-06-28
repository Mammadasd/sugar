package com.mammadali.diabetes.diabetes_tracker.dao.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mammadali.diabetes.diabetes_tracker.model.enums.MeasurementType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "blood_sugar_entries")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BloodSugarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double level;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MeasurementType type;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @JsonManagedReference
    private UserEntity user;


}
