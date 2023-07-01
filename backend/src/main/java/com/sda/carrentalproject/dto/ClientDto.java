package com.sda.carrentalproject.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record ClientDto(Long id,
                        String name,
                        String surname,
                        String phone,
                        String email,
                        String address,
                        boolean hasDrivingLicense,
                        LocalDateTime registrationDateTime,
                        LocalDate dateOfBirth
) {
}
