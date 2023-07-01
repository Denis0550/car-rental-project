package com.sda.carrentalproject.domain;


import jakarta.persistence.*;
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


    private String name;


    private String surname;


    private String phone;


    private String email;


    private String address;


    private boolean hasDrivingLicense;


    private LocalDateTime registrationDateTime;


    private LocalDate dateOfBirth;


    @PrePersist
    void recordRegistrationDateTime() {

        if (registrationDateTime == null) {
            registrationDateTime = LocalDateTime.now();
        }
    }




}
