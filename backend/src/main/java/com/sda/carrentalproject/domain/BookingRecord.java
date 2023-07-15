package com.sda.carrentalproject.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "BOOKING_RECORDS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Car bookedCar;

    @OneToOne
    private Client client;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    private long fullPriceInEuroCents;









}
