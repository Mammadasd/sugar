package com.mammadali.diabetes.diabetes_tracker.mapper;
import com.mammadali.diabetes.diabetes_tracker.dao.entity.BloodSugarEntity;
import com.mammadali.diabetes.diabetes_tracker.model.dto.request.BloodSugarCreateRequestDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.BloodSugarResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BloodSugarMapper {

    BloodSugarResponseDto toDto(BloodSugarEntity entity);

    // Əgər lazım olsa yeni qan şəkəri məlumatı yaratmaq üçün (UserEntity ignore)
    BloodSugarEntity toEntity(BloodSugarCreateRequestDto dto);





//    List<BloodSugarResponseDto> toDtoList(List<BloodSugarEntity> entities); buna ehtiyac yoxdur evezine streamden isdifade edirem



}

