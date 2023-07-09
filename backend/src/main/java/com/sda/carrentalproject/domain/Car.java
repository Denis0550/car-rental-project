package com.sda.carrentalproject.domain;

import com.sda.carrentalproject.domain.enumeration.Color;
import jakarta.persistence.*;
import lombok.*;

import java.time.YearMonth;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARS")
// TODO: homework =) implement on java and angular side :p
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private YearMonth productionYear;

    @Enumerated(EnumType.STRING)
    private Color color;

    private boolean available;

    private PriceList priceList;


}
