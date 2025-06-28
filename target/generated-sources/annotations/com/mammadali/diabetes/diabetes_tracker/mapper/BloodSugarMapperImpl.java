package com.mammadali.diabetes.diabetes_tracker.mapper;

import com.mammadali.diabetes.diabetes_tracker.dao.entity.BloodSugarEntity;
import com.mammadali.diabetes.diabetes_tracker.model.dto.request.BloodSugarCreateRequestDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.BloodSugarResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-28T18:08:55+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class BloodSugarMapperImpl implements BloodSugarMapper {

    @Override
    public BloodSugarResponseDto toDto(BloodSugarEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BloodSugarResponseDto.BloodSugarResponseDtoBuilder bloodSugarResponseDto = BloodSugarResponseDto.builder();

        bloodSugarResponseDto.id( entity.getId() );
        bloodSugarResponseDto.date( entity.getDate() );
        bloodSugarResponseDto.level( entity.getLevel() );
        bloodSugarResponseDto.type( entity.getType() );
        bloodSugarResponseDto.createdAt( entity.getCreatedAt() );

        return bloodSugarResponseDto.build();
    }

    @Override
    public BloodSugarEntity toEntity(BloodSugarCreateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        BloodSugarEntity.BloodSugarEntityBuilder bloodSugarEntity = BloodSugarEntity.builder();

        bloodSugarEntity.date( dto.getDate() );
        bloodSugarEntity.level( dto.getLevel() );
        bloodSugarEntity.type( dto.getType() );

        return bloodSugarEntity.build();
    }
}
