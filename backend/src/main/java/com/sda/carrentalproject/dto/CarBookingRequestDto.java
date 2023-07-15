package com.sda.carrentalproject.dto;

import java.time.LocalDate;
import lombok.Builder;


public record CarBookingRequestDto(
    long carToBookId,
    long clientId,
    LocalDate startDate,
    LocalDate endDate

) {

}
