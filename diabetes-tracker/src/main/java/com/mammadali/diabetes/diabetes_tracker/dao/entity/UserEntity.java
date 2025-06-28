package com.mammadali.diabetes.diabetes_tracker.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mammadali.diabetes.diabetes_tracker.model.enums.Role;
//import com.mammadali.diabetes.diabetes_tracker.model.enums.Status;kmmgkfdmgkfdmgvkfdmkgmfdkmkfdv
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @BatchSize(size = 10)
    @ToString.Exclude
    @JsonBackReference
    private List<BloodSugarEntity> bloodSugarEntries;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;







    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Sadəcə bir rol var, onu da SimpleGrantedAuthority ilə qaytarırıq
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email; // login üçün e-mail istifadə edəcəyik
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true; // istəsək, @Column(nullable=false) enabled field də əlavə edə bilərdik
    }
}



