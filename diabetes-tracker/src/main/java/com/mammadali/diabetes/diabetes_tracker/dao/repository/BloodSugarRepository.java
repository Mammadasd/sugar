package com.mammadali.diabetes.diabetes_tracker.dao.repository;

import com.mammadali.diabetes.diabetes_tracker.dao.entity.BloodSugarEntity;
import com.mammadali.diabetes.diabetes_tracker.dao.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BloodSugarRepository extends JpaRepository<BloodSugarEntity, Long> {

    List<BloodSugarEntity> findByUserId(Long userId);

    List<BloodSugarEntity> findByUser(UserEntity user);
}


