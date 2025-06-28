package com.mammadali.diabetes.diabetes_tracker.service;

import com.mammadali.diabetes.diabetes_tracker.dao.entity.BloodSugarEntity;
import com.mammadali.diabetes.diabetes_tracker.dao.entity.UserEntity;
import com.mammadali.diabetes.diabetes_tracker.dao.repository.BloodSugarRepository;
import com.mammadali.diabetes.diabetes_tracker.mapper.BloodSugarMapper;
import com.mammadali.diabetes.diabetes_tracker.model.dto.request.BloodSugarCreateRequestDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.BloodSugarResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BloodSugarService {
    private final BloodSugarRepository bloodSugarRepository;
    private final BloodSugarMapper bloodSugarMapper;

    public void create(BloodSugarCreateRequestDto dto, UserEntity user) {
        if (dto.getDate() == null) {
            dto.setDate(LocalDate.now());
        }
        BloodSugarEntity entity = bloodSugarMapper.toEntity(dto);
        entity.setUser(user);
        bloodSugarRepository.save(entity);
    }

    public List<BloodSugarResponseDto> getAllByUser(UserEntity user) {
        return bloodSugarRepository.findByUser(user).stream()
                .map(bloodSugarMapper::toDto)
                .collect(Collectors.toList());

    }


}
