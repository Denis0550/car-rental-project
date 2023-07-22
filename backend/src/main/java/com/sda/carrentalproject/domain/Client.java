package com.sda.carrentalproject.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "CLIENTS")
@NoArgsConstructor
@AllArgsConstructor
public class Client {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min=2)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Size(min=2)
    private String surname;

    @NotNull
    @Size(min=7)
    private String phone;

    // TODO: validate uniqueness other that h2 database
    @Email
    @NotNull
    @Column(nullable = false, unique = true)
    private String email;


    private String address;


    private boolean hasDrivingLicense;


    private LocalDateTime registrationDateTime;

    @Past
    private LocalDate dateOfBirth;


    @PrePersist
    void recordRegistrationDateTime() {

        if (registrationDateTime == null) {
            registrationDateTime = LocalDateTime.now();
        }
    }




}
