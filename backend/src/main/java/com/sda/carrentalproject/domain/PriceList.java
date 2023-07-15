package com.sda.carrentalproject.domain;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
public class PriceList {

    long pricePerDayInEuroCents;


}
