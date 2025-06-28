package com.mammadali.diabetes.diabetes_tracker.service;
import com.mammadali.diabetes.diabetes_tracker.dao.repository.BloodSugarRepository;
import com.mammadali.diabetes.diabetes_tracker.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final BloodSugarRepository bloodSugarRepository;



//
//    public List<AdminUserDto> getAllUsers(){
//        List<UserEntity> users = userRepository.findAll();
//
//    return users.stream()
//            .map()}
}
