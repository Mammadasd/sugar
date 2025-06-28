package com.mammadali.diabetes.diabetes_tracker.mapper;

import com.mammadali.diabetes.diabetes_tracker.dao.entity.BloodSugarEntity;
import com.mammadali.diabetes.diabetes_tracker.dao.entity.UserEntity;
import com.mammadali.diabetes.diabetes_tracker.model.dto.request.UserRegisterRequestDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.AdminUserDetailDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.BloodSugarResponseDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.UserProfileDto;
import com.mammadali.diabetes.diabetes_tracker.model.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-28T18:08:55+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private BloodSugarMapper bloodSugarMapper;

    @Override
    public UserEntity toUserEntity(UserRegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.firstName( dto.getFirstName() );
        userEntity.lastName( dto.getLastName() );
        userEntity.email( dto.getEmail() );
        userEntity.password( dto.getPassword() );
        userEntity.birthDate( dto.getBirthDate() );

        userEntity.role( Role.USER );

        return userEntity.build();
    }

    @Override
    public UserProfileDto toUserProfileDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserProfileDto.UserProfileDtoBuilder userProfileDto = UserProfileDto.builder();

        userProfileDto.id( entity.getId() );
        userProfileDto.firstName( entity.getFirstName() );
        userProfileDto.lastName( entity.getLastName() );
        userProfileDto.email( entity.getEmail() );
        userProfileDto.birthDate( entity.getBirthDate() );

        return userProfileDto.build();
    }

    @Override
    public AdminUserDetailDto toUserDetailDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AdminUserDetailDto.AdminUserDetailDtoBuilder adminUserDetailDto = AdminUserDetailDto.builder();

        adminUserDetailDto.id( entity.getId() );
        adminUserDetailDto.firstName( entity.getFirstName() );
        adminUserDetailDto.lastName( entity.getLastName() );
        adminUserDetailDto.email( entity.getEmail() );
        adminUserDetailDto.birthDate( entity.getBirthDate() );
        adminUserDetailDto.createdAt( entity.getCreatedAt() );
        adminUserDetailDto.updatedAt( entity.getUpdatedAt() );
        adminUserDetailDto.bloodSugarEntries( bloodSugarEntityListToBloodSugarResponseDtoList( entity.getBloodSugarEntries() ) );

        return adminUserDetailDto.build();
    }

    protected List<BloodSugarResponseDto> bloodSugarEntityListToBloodSugarResponseDtoList(List<BloodSugarEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<BloodSugarResponseDto> list1 = new ArrayList<BloodSugarResponseDto>( list.size() );
        for ( BloodSugarEntity bloodSugarEntity : list ) {
            list1.add( bloodSugarMapper.toDto( bloodSugarEntity ) );
        }

        return list1;
    }
}
