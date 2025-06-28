package com.mammadali.diabetes.diabetes_tracker;

import com.mammadali.diabetes.diabetes_tracker.dao.entity.UserEntity;
import com.mammadali.diabetes.diabetes_tracker.dao.repository.UserRepository;
import com.mammadali.diabetes.diabetes_tracker.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) {
        if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {
            UserEntity admin = UserEntity.builder()
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("1234"))
                    .firstName("Admin")
                    .lastName("User")
                    .role(Role.ADMIN)
                    .build();

            userRepository.save(admin);
        }
    }
}
