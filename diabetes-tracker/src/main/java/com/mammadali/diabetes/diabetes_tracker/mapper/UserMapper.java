package com.mammadali.diabetes.diabetes_tracker.mapper;

import com.mammadali.diabetes.diabetes_tracker.dao.entity.UserEntity;
import com.mammadali.diabetes.diabetes_tracker.model.dto.request.UserRegisterRequestDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.AdminUserDetailDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.UserProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring", uses = BloodSugarMapper.class)
public interface UserMapper {
//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "role", constant = "USER")
    UserEntity toUserEntity(UserRegisterRequestDto dto);

    // Tək user üçün profile mapping (istifadəçi özü və ya admin baxanda)
    UserProfileDto toUserProfileDto(UserEntity entity);

    //Admin üçün detalli
    AdminUserDetailDto toUserDetailDto(UserEntity entity);






    // Birdən çox user üçün profile mapping (admin listə baxanda)
//    List<UserProfileDto> toProfileDtoList(List<UserEntity> users);  evezine stream den isdifade edecem








}

