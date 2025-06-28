package com.mammadali.diabetes.diabetes_tracker.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequestDto {

    @NotBlank(message = "Ad boş ola bilməz")
    private String firstName;

    @NotBlank(message = "Soyad boş ola bilməz")
    private String lastName;

    @Email(message = "Email düzgün deyil")
    @NotBlank(message = "Email boş ola bilməz")
    private String email;


    @NotBlank(message = "Parol boş ola bilməz")
    @Size(min = 8, message = "Parol ən az 8 simvol olmalıdır")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Parol ən az 1 böyük hərf, 1 kiçik hərf, 1 rəqəm və 1 xüsusi simvol içərməlidir")
    private String password;

    @Past(message = "Doğum tarixi keçmiş tarix olmalıdır")
    private LocalDate birthDate;

}
