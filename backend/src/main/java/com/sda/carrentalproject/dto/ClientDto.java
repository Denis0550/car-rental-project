package com.sda.carrentalproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;


// TODO: add nulls and not nulls annotations
@Builder
public record ClientDto(Long id,
                        @NotNull
                        @Size(min=2)
                        String name,

                        @NotNull
                        @Size(min=2)
                        String surname,

                        @NotNull
                        @Size(min=7)
                        String phone,

                        @Email
                        String email,

                        String address,

                        boolean hasDrivingLicense,

                        LocalDateTime registrationDateTime,

                        @Past
                        LocalDate dateOfBirth
) {
}
