package com.sda.carrentalproject.dto;

import com.sda.carrentalproject.domain.Car;
import com.sda.carrentalproject.domain.Client;
import java.time.LocalDate;
import lombok.Builder;

@Builder
public record BookingRecordDto (
    Long id,
    CarDto bookedCar,
    ClientDto client,
    LocalDate startDate,
    LocalDate endDate,
    long fullPriceInEuroCents
) {

}
