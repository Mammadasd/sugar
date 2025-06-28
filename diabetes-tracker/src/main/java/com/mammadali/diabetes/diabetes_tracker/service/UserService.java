package com.mammadali.diabetes.diabetes_tracker.service;

import com.mammadali.diabetes.diabetes_tracker.dao.entity.UserEntity;
import com.mammadali.diabetes.diabetes_tracker.dao.repository.UserRepository;
import com.mammadali.diabetes.diabetes_tracker.mapper.UserMapper;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.AdminUserDetailDto;
import com.mammadali.diabetes.diabetes_tracker.model.dto.response.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserProfileDto getProfile(UserEntity user) {
        return userMapper.toUserProfileDto(user);
    }


    public AdminUserDetailDto getUserDetail(Long id) {
        return userMapper.toUserDetailDto(
                userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Tapılmadı")));

    }

    public List<UserProfileDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserProfileDto)
                .collect(Collectors.toList());
    }

}





